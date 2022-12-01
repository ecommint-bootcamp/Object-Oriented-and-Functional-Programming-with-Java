package org.javaturk.jpa.ch03.em;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class RemoveTest extends Test {

	public static void main(String[] args) {
		RemoveTest test = new RemoveTest();
//		test.removePerson(151);
//		test.removeDetachedPerson(1);
//		test.removeDetachedAndMergedPerson(20);
		test.removeAllPersons();
		
		PersistenceUtil.close();
	}

	public void removePerson(int id) {
		System.out.println("\nRemoving the person with id: " + id);

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person person = em.find(Person.class, id);
		System.err.println("Person to be removed: " + person);
		em.remove(person);

		tx.commit();
		em.close();
		
		System.err.println("Person removed: " + person);
	}
	
	public void removeDetachedPerson(int id) {
		System.out.println("\nRemoving a detached person with id: " + id);

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person person = em.find(Person.class, id);
		
		tx.commit();
		em.close();
		
		person = markForRemoval(person);
		
		em = PersistenceUtil.getEntityManager();
		tx = em.getTransaction();
		tx.begin();
		
		if(person.isRemoveIt()) {
			System.err.println("Removing: " + person);
			em.remove(person);
		}

		tx.commit();
		em.close();
		
		System.err.println("Person removed: " + person);
	}
	
	public void removeDetachedAndMergedPerson(int id) {
		System.out.println("\nRemoving a detached and merged person with id: " + id);

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person person = em.find(Person.class, id);
		
		tx.commit();
		em.close();
		
		em = PersistenceUtil.getEntityManager();
		tx = em.getTransaction();
		tx.begin();
		
		person = markForRemoval(person);
		
		if(person.isRemoveIt()) {
			System.err.println("Person is being merged: " + person);
			Person personMerged = em.merge(person);
			System.err.println("Removing: " + personMerged);
			em.remove(personMerged);
		}
		
		tx.commit();
		em.close();
		
		System.err.println("Person removed: " + person);
	}

	public void removeAllPersons() {
		System.out.println("\nRemoving all persons: ");

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query allPersons = em.createQuery("Select c from Person c");
		Collection<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");
		for (Person person : persons)
			em.remove(person);

		tx.commit();
		em.close();
	}
	
	private Person markForRemoval(Person p) {
		p.removeIt();
		return p;
	}
}
