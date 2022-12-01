package org.javaturk.jpa.ch03.em;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class PersistTest extends Test {

	public static void main(String[] args) {
		PersistTest test = new PersistTest();
//		test.persistPerson();
//		test.persistPersons(100);
//		test.persistCar();
//		test.persistCar(10);
//		test.persistDetachedPerson(1);
		
		PersistenceUtil.close();
	}

	void persistPerson() {
		System.err.println("Persisting a person.");
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Person p = new Person();
		p.setId(54545454);
		p.setFirstName("Selim");
		p.setLastName("Karatas");
	
		em.persist(p);
		tx.commit();
	

		Query query = em.createQuery("Select p from Person p");
		List<Person> persons = query.getResultList();
		System.out.println("Number of the persons: " + persons.size());
		em.close();
	}

	void persistPersons(int n) {
		System.err.println("Persisting " + n + " persons.");
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person p = null;
		for (int i = 0; i < n; i++) {
			p = Factory.createPerson();
			em.persist(p);
		}

		tx.commit();
		em.close();
	}

	void persistCar() {
		System.err.println("Persisting a car.");
		Car car = new Car("Mercedes", "C200", "2010");
		System.err.println("Car to be persisted: " + car);

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(car);
		System.err.println("Car persisted: " + car);
		tx.commit();
		em.close();
	}

	void persistCar(int n) {
		System.err.println("Persisting " + n + " cars.");

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Car car = null;
		for (int i = 0; i < n; i++) {
			car = Factory.createCar();
			System.err.println("\nCar to be persisted: " + car);
			em.persist(car);
			System.err.println("Car persisted: " + car);
		}
		tx.commit();
		em.close();
	}
	
	private void persistDetachedPerson(int id) {
		System.err.println("Persisting a detached person with id: " + id);
		EntityManager em = PersistenceUtil.getEntityManager();
		Person detachedPerson = em.find(Person.class, id);	
		em.close();
		
		em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(detachedPerson);
		tx.commit();
		em.close();
	}
}
