
package org.javaturk.jpa.ch07.concurrency;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.swing.JOptionPane;

import org.javaturk.jpa.ch07.concurrency.domain.Person;
import org.javaturk.jpa.util.PersistenceUtil;

public class Checker extends Thread{
	private String query;

	private LockModeType mode;
	private int checkId;

	public Checker(LockModeType mode, int checkId) {
		super("Checker");
		this.mode = mode;
		this.checkId = checkId;
		PersistenceUtil.setPersistenceUnitName("personLocking");
	}

	public void run() {
		System.err.println("=> Checker starts.");

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Person person = em.find(Person.class, checkId, mode);
		System.out.println("Person retrieved: " + person);

		tx.commit();
		em.close();
	}
}
