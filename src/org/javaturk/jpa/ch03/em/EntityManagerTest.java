package org.javaturk.jpa.ch03.em;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class EntityManagerTest {
	
	public EntityManagerTest() {
		PersistenceUtil.setPersistenceUnitName("em");
	}

	public static void main(String[] args) {

		EntityManagerTest test = new EntityManagerTest();
//		test.isOpenTest(40, 110);
		test.printInfo(40, 110);
//		test.testInstances(156);
		
		PersistenceUtil.close();
	}
	
	public void isOpenTest(int personId, int carId) {
		System.out.println("\nFetching a person with id " + personId + " and a car with id " + carId);
		EntityManager em = PersistenceUtil.getEntityManager();
		System.out.println("Is EM open after creation: " + em.isOpen());
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person person = em.find(Person.class, personId);
		System.err.println("Person fetched: " + person);
		
		Car car = em.find(Car.class, carId);
		System.err.println("Car fetched: " + car);
		
		person.setLastName(person.getLastName() + "A");
		car.setMake(car.getMake() + "B");
		tx.commit();
		
		System.out.println("Is EM open after commit(): " + em.isOpen());
		
		tx = em.getTransaction();
		tx.begin();
		person.setLastName(person.getLastName() + "A1");
		car.setMake(car.getMake() + "B1");
		em.clear();
		System.out.println("Is EM open after clear(): " + em.isOpen());
		tx.commit();
		
		em.close();
		System.out.println("Is EM open ofler close(): " + em.isOpen());
	}
	
	public void printInfo(int personId, int carId) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person person = em.find(Person.class, personId);
		Car car = em.find(Car.class, carId);
		
		System.out.println("Flush mode: " + em.getFlushMode());
		System.out.println("Lock mode of Person instance: " + em.getLockMode(person));
		System.out.println("Lock mode of Car instance: " + em.getLockMode(car));
		
		System.out.println("\n*** Properties ***");
		Map<String, Object> properties = em.getProperties();
		Set<String> keys = properties.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + ": " + properties.get(key));
		}
		tx.commit();
		em.close();
	}
	
	private void testInstances(int id) {
		System.out.println("\nFetching person with id " + id);
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		Person person1 = em.find(Person.class, id);
		System.out.println("Person1: " + person1);
		
		Person person2 = em.find(Person.class, id);
		System.out.println("Person2: " + person2);
		
		if(person1 == person2)
			System.err.println("The same");
		else
			System.err.println("Different");
		
		System.out.println("Sending query: \"Select p From Person p where p.id=\"" + id);
		
		Query query = em.createQuery("Select p From Person p where p.id=" + id);
		Person person3 = (Person) query.getSingleResult();
		System.out.println("Person3: " + person3);
		
		if(person1 == person3)
			System.err.println("The same");
		else
			System.err.println("Different");
		
		if(person2 == person3)
			System.err.println("The same");
		else
			System.err.println("Different");
		
		System.out.println("Sending query: \"Select p From Person p\"");
		
		query = em.createQuery("Select p From Person p");
		Collection<Person> collection = query.getResultList();
		
		for(Person p : collection) {
			if(p.getId() == person1.getId()) {
				System.out.println("Person with the same id from the query result: " + p);
				if(person1 == p)
					System.err.println("The same");
				else
					System.err.println("Different");
			}
		}
		
		em.close();
	}
}
