package org.javaturk.jpa.ch03.em;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.javaturk.jpa.util.PersistenceUtil;

public class FindTest extends Test {

	public static void main(String[] args) {
		FindTest test = new FindTest();
		test.retrievePersonWithID(1);
		
		PersistenceUtil.close();
	}

	public void retrievePersonWithID(int id) {
		System.out.println("\nFinding person with id " + id);
		EntityManager em = PersistenceUtil.getEntityManager();
		
		Person person = em.find(Person.class, id);

		if (person == null)
			System.err.println("No such entity with id: " + id + " found!");
		else
			System.err.println("Found entity: " + person);
		
		em.close();
	}
}
