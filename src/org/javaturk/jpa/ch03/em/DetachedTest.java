package org.javaturk.jpa.ch03.em;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.javaturk.jpa.util.PersistenceUtil;

public class DetachedTest extends Test {

	public static void main(String[] args) {
		DetachedTest test = new DetachedTest();
//		test.updatePersonWithID(151);
//		test.detachPersonWithID(152);
		test.clearPersistentContext(152, 101);
		
		PersistenceUtil.close();
	}

	public void updatePersonWithID(int id) {
		System.out.println("\nFinding person with id " + id);
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person person = em.find(Person.class, id);
		System.err.println("Person fetched: " + person);
		person.setLastName(person.getLastName() + "X");
		System.err.println("Updated person: " + person);
		tx.commit();
		em.close();

		System.out.println("EntityManager is closed.");
		person.setLastName(person.getLastName() + "Y");
		
		em = PersistenceUtil.getEntityManager();
		person = em.find(Person.class, id);
		System.err.println("Person fetched: " + person);
		em.close();
	}
	
	public void detachPersonWithID(int id) {
		System.out.println("\nFinding person with id " + id);
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person person = em.find(Person.class, id);
		System.err.println("Person fetched: " + person);
		System.out.println("Detaching the entity.");
		
		em.detach(person);
		
		person.setLastName(person.getLastName() + "X");
		System.err.println("Updated person: " + person);
		
		Person personFetched = em.find(Person.class, id);
		System.err.println("Person personFetched: " + personFetched);
		tx.commit();
		em.close();
	}
	
	public void clearPersistentContext(int personId, int carId) {
		System.out.println("\nFetching a person with id " + personId + " and a car with id " + carId);
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person person = em.find(Person.class, personId);
		System.err.println("Person fetched: " + person);
		
		Car car = em.find(Car.class, carId);
		System.err.println("Car fetched: " + car);
		
		em.clear();
		System.out.println("Peristent context is cleared.");
		
		person.setLastName(person.getLastName() + "X");
		System.err.println("Updated person: " + person);
		car.setMake(car.getMake() + "Y");
		System.err.println("Updated car: " + car);
		
		tx.commit();
		em.close();
		
		System.out.println("Peristent context is closed.");
		em = PersistenceUtil.getEntityManager();
		person = em.find(Person.class, personId);
		System.err.println("Person fetched: " + person);
		car = em.find(Car.class, carId);
		System.err.println("Car fetched: " + car);
		
		em.close();
	}
}
