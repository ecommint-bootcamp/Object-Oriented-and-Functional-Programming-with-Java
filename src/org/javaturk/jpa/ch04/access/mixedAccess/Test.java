package org.javaturk.jpa.ch04.access.mixedAccess;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("mixedAccess");
	}

	public static void main(String[] args) {

		Test test = new Test();

		test.createPerson();
//		test.createPersons(5);
//		 test.retrieveAPerson(1);
//		 test.retrieveAllPersons();

	}

	void createPerson() {
		System.out.println("Creating a person.");
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

	void createPersons(int n) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person p = null;
		for (int i = 0; i < n; i++) {
			p = Factory.createPerson(); // Unique constraints on Table and
										// Column may give you trouble
			em.persist(p);
		}

		tx.commit();
		em.close();
	}

	private void retrieveAPerson(int id) {
		System.out.println("\nRetrieving the person with id: " + id);
		EntityManager em = PersistenceUtil.getEntityManager();

		Person person = em.find(Person.class, id);
		if (person == null)
			System.out.println("No such person!");
		else
			System.out.println("\n" + person);
	}

	public void retrieveAllPersons() {
		System.out.println("\nAll of the persons: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allPersons = em.createQuery("from Person");
		Collection<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");

		for (Person person : persons)
			System.out.println(person);
		em.close();
	}
}
