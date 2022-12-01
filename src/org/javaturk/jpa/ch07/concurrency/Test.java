
package org.javaturk.jpa.ch07.concurrency;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;

import static javax.persistence.LockModeType.*;

import org.javaturk.jpa.ch07.concurrency.domain.*;
import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("personLocking");
	}

	public static void main(String[] args) {
		Test test = new Test();
//		test.createPerson();
//		test.createPersons(1000);

//		 test.doCommittedRead(NONE, 2);

		// Do optimistic tx
//		test.doTransactionWithLocking(OPTIMISTIC, 2);

//		test.doRepeatableRead(NONE);

		// Do pessimistic tx
		test.doTransactionWithLocking(PESSIMISTIC_READ, 3);
		
//		PersistenceUtil.close();
	}

	public void createPerson() {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Person p = new Person();
		p.setFirstName("Mihrimah");
		p.setLastName("Kaldiroglu");

		em.persist(p);

		tx.commit();
		em.close();
	}

	public void createPersons(int count) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		for (int i = 0; i < count; i++) {
			Person p = Factory.createPerson();
			em.persist(p);
		}

		tx.commit();
		em.close();
	}

	public void doCommittedRead(LockModeType mode, int id) {
		Updater updater = new Updater("Updater", mode, id);
		updater.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Checker checker = new Checker(mode, id);
		checker.start();
	}

	public static void doRepeatableRead(LockModeType mode) {

		DoubleChecker checker = new DoubleChecker(mode);
		checker.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Updater updater = new Updater("Updater", mode, 1400728916);
		updater.start();
	}

	public void doTransactionWithLocking(LockModeType mode, int id) {

		Updater updater1 = new Updater("Updater1", mode, id);
		updater1.start();

//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		Updater updater2 = new Updater("Updater2", mode, id);
		updater2.start();
	}
}
