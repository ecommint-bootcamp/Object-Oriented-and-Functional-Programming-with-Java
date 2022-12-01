package org.javaturk.jpa.ch04.id.auto;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("auto");
	}

	public static void main(String[] args) {
		Test test = new Test();

		test.createPersonByAutoIdentity();
//		test.retrieveAllPersons();
	}

	private void createPersonByAutoIdentity() {
		System.out.println("Creating a person with an auto id");
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person p1 = new Person("Mihrimah", "Kaldiroglu");
		em.persist(p1);

		Person p2 = new Person("Selim", "Ay");
		em.persist(p2);

		tx.commit();
		em.close();
	}

	public void retrieveAllPersons() {
		System.out.println("\nAll of the persons: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allPersons = em.createQuery("Select p from Person p");
		Collection<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");
		for (Person person : persons)
			System.out.println(person);
		em.close();
	}
}
