package org.javaturk.jpa.ch03.em;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.javaturk.jpa.util.PersistenceUtil;

public class MergeTest extends Test {

	public static void main(String[] args) {
		
		MergeTest test = new MergeTest();
//		test.mergePerson(151);
		test.fetchUpdateAndMergePerson(151);
//		test. testContains(30);
		
		PersistenceUtil.close();
	}

	public void mergePerson(int id) {
		System.out.println("\nDetaching the person with id " + id);

		EntityManager em = PersistenceUtil.getEntityManager();
		Person detachedPerson = em.find(Person.class, id);
		System.out.println("Person info: " + detachedPerson);

//		em.close();
//		em.clear();
		em.detach(detachedPerson);
		detachedPerson.setLastName("Detached");

		em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person mergedPerson = em.merge(detachedPerson);
		// em.clear();
		// Person mergedPerson2 = em.find(Person.class, detachedPerson.getId());
		//
		// mergedPerson.setFirstName("YYY");
		// System.out.println(mergedPerson.hashCode());
		// mergedPerson2.setFirstName("??kiX");
		// System.out.println(mergedPerson2.hashCode());
		detachedPerson.setFirstName("UUU");

		tx.commit();

		mergedPerson = em.find(Person.class, id);
		System.out.println("Customer info (merged): " + mergedPerson);
		System.out.println("Customer info (detached): " + detachedPerson);

		em.close();
	}

	public Person fetchPersonWithID(int id) {
		System.out.println("\nFetching a person with id " + id);
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		Person person = em.find(Person.class, id);
		em.close();
		return person;
	}

	public void fetchUpdateAndMergePerson(int id) {
		System.out.println("\nFetching a person with id " + id);
		Person person = fetchPersonWithID(id);
		System.err.println("Fetched person: " + person);
		
		person.setLastName(person.getLastName() + "Z");
		System.err.println("Updated person: " + person);
		
		updatePerson(person);
		
		person = fetchPersonWithID(id);
		System.err.println("Fetched the updated person: " + person);
	}

	public void updatePerson(Person person) {
		System.out.println("\nUpdating a person with id: " + person);
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(person);
		tx.commit();
		em.close();
	}
	
	public void testContains(int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Person person = em.find(Person.class, id);
		System.err.println("Person contained in the persistent context: " + em.contains(person));
		em.close();
		
		person.setLastName(person.getLastName() + "W");
		
		em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		System.err.println("Person contained in the persistent context: " + em.contains(person));
		Person personMerged = em.merge(person);
		System.err.println("Person contained in the persistent context: " + em.contains(person));
		System.err.println("Person merged contained in the persistent context: " + em.contains(personMerged));

		tx.commit();
		em.close();
	}
	
}
