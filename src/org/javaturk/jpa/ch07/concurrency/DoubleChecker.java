
package org.javaturk.jpa.ch07.concurrency;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.javaturk.jpa.ch07.concurrency.domain.Person;
import org.javaturk.jpa.util.PersistenceUtil;

public class DoubleChecker extends Thread {
	private int readCount;
	private LockModeType mode;

	public DoubleChecker(LockModeType mode) {
		super("DoubleChecker");
		this.mode = mode;
		PersistenceUtil.setPersistenceUnitName("personLocking");
	}

	public void run() {
		
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		runQuery(em, tx);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();

		runQuery(em, tx);
		
		tx.commit();
		em.close();
	}

	private void runQuery(EntityManager em, EntityTransaction tx) {
		readCount++;
		
		System.err.println("=> DoubleChecker starts. Run count: " + readCount);

		TypedQuery<Person> query = em.createQuery("Select p from Person p Where p.lastName = 'Boyaci'", Person.class);
		query.setLockMode(mode);
		Collection<Person> persons = query.getResultList();
		System.out.println("Size of collection: " + persons.size());
		for(Person p : persons)
			System.out.println(p);
	}
}
