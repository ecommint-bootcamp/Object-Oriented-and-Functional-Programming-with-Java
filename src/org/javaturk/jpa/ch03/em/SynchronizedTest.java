package org.javaturk.jpa.ch03.em;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class SynchronizedTest extends Test {

	public static void main(String[] args) {
		SynchronizedTest test = new SynchronizedTest();
		test.updatePerson(1);
//		test.updatePersons("Zafer");
		
//		PersistenceUtil.close();
	}

	public void updatePerson(int id) {
		System.err.println("\nUpdating a person with id: " + id);
		EntityManager em = PersistenceUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person person = em.find(Person.class, id);
		System.err.println("Person fetched from the db: " + person);

		person.setLastName(person.getLastName() + random.nextInt(1000));
		System.err.println("Updated person: " + person);

		tx.commit();
		em.close();
		
		em = PersistenceUtil.getEntityManager();
		person = em.find(Person.class, id);
		System.err.println("Person fetched from the db: " + person);
		em.close();
	}

	public void updatePersons(String lastname) {
		System.err.println("\nUpdating persons with lastname : " + lastname);
		EntityManager em = PersistenceUtil.getEntityManager();
		Query personsWithGivenLastname = em.createQuery("Select p from Person p Where p.lastName='" + lastname + "'");

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Collection<Person> persons = personsWithGivenLastname.getResultList();
		System.err.println(persons.size() + " objects:");
		for (Person person : persons) {
			person.setLastName(person.getLastName() + 'X');
		}

		tx.commit();
		em.close();
	}
}
