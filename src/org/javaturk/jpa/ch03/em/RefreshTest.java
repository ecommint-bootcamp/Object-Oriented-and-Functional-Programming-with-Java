package org.javaturk.jpa.ch03.em;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.javaturk.jpa.util.PersistenceUtil;

public class RefreshTest extends Test{

	public static void main(String[] args) {
		RefreshTest test = new RefreshTest();
		test.refresh(251);
	}
	
	private void refresh(int id) {
		System.out.println("\nFetching a person with id: " + id);
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person person = em.find(Person.class, id);
		System.err.println("Person fetched: " + person);
		person.setLastName(person.getLastName() + random.nextInt(1000));
		System.err.println("Updated person: " + person);
		
		em.flush();
		
		System.out.println("Refreshing person");

		em.refresh(person);
		
		System.err.println("Person refreshed: " + person);
		tx.commit();
		em.close();
	}
}
