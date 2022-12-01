package org.javaturk.jpa.ch07.version;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.swing.JOptionPane;

import org.javaturk.jpa.ch08.oql.simple.Factory;
import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("lock");
	}

	public static void main(String[] args) {
		Test test = new Test();
//		test.createPerson();
//		test.retrievePerson(1);
		test.optimisticlyLockPerson(1);
//		test.pessimisticlyLockPerson(1);
//		test.concurrentlyChangeLockedObject(51);
		
		PersistenceUtil.close();

	}

	void createPerson() {
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

	public void retrievePerson(int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person person = em.find(Person.class, id);
		System.out.println("Person: " + person);
		tx.commit();
		em.close();
	}
	
	public void optimisticlyLockPerson(int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person person = em.find(Person.class, id, LockModeType.OPTIMISTIC);
		System.out.println("Before: " + person);
		person.setLastName("Optimistic-" + person.getVersion());
		System.out.println("After: " + person);
		tx.commit();
		em.close();
	}

	public void pessimisticlyLockPerson(int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person person = em.find(Person.class, id, LockModeType.PESSIMISTIC_READ);
		System.out.println("Before: " + person);
		person.setLastName("Pessimistic-" + person.getVersion());
		System.out.println("After: " + person);
		tx.commit();
		em.close();
	}

	public void concurrentlyChangeLockedObject(int id) {

		EntityManager em = PersistenceUtil.getEntityManager();
		em.setProperty("javax.persistence.lock.timeout", 1);
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person person = em.find(Person.class, id, LockModeType.PESSIMISTIC_READ);
//		em.lock(person, LockModeType.PESSIMISTIC_READ);
		System.out.println(person);

		String newLastName = JOptionPane.showInputDialog("Please enter new last name:");
		person.setLastName(newLastName);

		tx.commit();
		em.close();
	}

}
