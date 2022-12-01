package org.javaturk.jpa.ch03.em;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.javaturk.jpa.util.PersistenceUtil;

/**
 * This is based on DetachedTest.java
 * @author akin
 *
 */
public class ContainsTest extends Test {

	public static void main(String[] args) {
		ContainsTest test = new ContainsTest();
//		test.updatePersonWithID(151);
//		test.detachPersonWithID(151);
		test.clearPersistentContext(151, 101);
		
		PersistenceUtil.close();
	}

	public void updatePersonWithID(int id) {
		System.out.println("\nFinding person with id " + id);
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person person = em.find(Person.class, id);
		System.err.println("Person fetched: " + person);
		System.err.println("Person contained in the persistent context: " + em.contains(person));
		
		person.setLastName(person.getLastName() + "X");
		System.err.println("Updated person: " + person);
		tx.commit();
		System.err.println("Person contained in the persistent context: " + em.contains(person));
		em.close();

		System.out.println("EntityManager is closed.");
		person.setLastName(person.getLastName() + "Y");
		em = PersistenceUtil.getEntityManager();
		System.err.println("Person contained in the persistent context: " + em.contains(person));
		
		person = em.find(Person.class, id);
		System.err.println("Person fetched: " + person);
		System.err.println("Person contained in the persistent context: " + em.contains(person));
		em.close();
	}
	
	public void detachPersonWithID(int id) {
		System.out.println("\nFinding person with id " + id);
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Person person = em.find(Person.class, id);
		System.err.println("Person fetched: " + person);
		System.out.println("Person contained in the persistent context: " + em.contains(person));
		
		System.out.println("Detaching the entity.");
		em.detach(person);
		
		System.err.println("Person contained in the persistent context: " + em.contains(person));
		person.setLastName(person.getLastName() + "X");
		System.err.println("Updated person: " + person);
		
		Person personFetched = em.find(Person.class, id);
		System.err.println("Person personFetched: " + person);
		System.err.println("Person contained in the persistent context: " + em.contains(personFetched));
		
		tx.commit();
		em.close();
	}
	
	public void clearPersistentContext(int personId, int carId) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person person = em.find(Person.class, personId);
		System.err.println("Person fetched: " + person);
		
		Car car = em.find(Car.class, carId);
		System.err.println("Car fetched: " + car);
		
		System.err.println("Person contained in the persistent context: " + em.contains(person));
		System.err.println("Car contained in the persistent context: " + em.contains(car));
		
		em.clear();
		System.out.println("\nPeristent context is cleared.");
		System.err.println("\nPerson contained in the persistent context: " + em.contains(person));
		System.err.println("Car contained in the persistent context: " + em.contains(car));
		
		person.setLastName(person.getLastName() + "X");
		System.err.println("\nUpdated person: " + person);
		car.setMake(car.getMake() + "Y");
		System.err.println("Updated car: " + car);
		
		tx.commit();
		em.close();
		
		System.out.println("Peristent context is closed.");
		
		System.out.println("\nPeristent context is re-created now.");
		em = PersistenceUtil.getEntityManager();
		person = em.find(Person.class, personId);
		System.err.println("Person fetched: " + person);
		car = em.find(Car.class, carId);
		System.err.println("Car fetched: " + car);
		System.err.println("\nPerson contained in the persistent context: " + em.contains(person));
		System.err.println("Car contained in the persistent context: " + em.contains(car));
		
		em.close();
	}
}
