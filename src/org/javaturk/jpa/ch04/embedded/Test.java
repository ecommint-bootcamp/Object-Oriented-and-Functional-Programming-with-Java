package org.javaturk.jpa.ch04.embedded;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {
	private EntityManagerFactory entityManagerFactory;

	public Test() {
		PersistenceUtil.setPersistenceUnitName("personEmbedded");
	}

	public static void main(String[] args) {
		Test test = new Test();

		test.createAPersonAndAStudent();
//		test.createAPerson();
		test.retrieveAllPersons();

	}
	
	void createAPersonAndAStudent() {
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		System.out.println("Creating a person and a student embedding an address:");

		tx.begin();

		Person p = new Person();
		p.setFirstName("Mihrimah");
		p.setLastName("Kaldiroglu");

		Address a1 = new Address();
		a1.setStreet("Gul Mahallesi, Cicek Sokak");
		a1.setAppt("77");
		a1.setCity("Izmir");
		a1.setZipCode("12345");
		p.setAddress(a1);
		
		em.persist(p);
		
		Student s = new Student();
		s.setFirstName("Akin");
		s.setLastName("Kaldiroglu");
		
		Address a2 = new Address();
		a2.setStreet("Sefa Caddesi, 17. Sokak");
		a2.setAppt("59");
		a2.setCity("Ayvalik");
		a2.setZipCode("10400");
		s.setAddress(a2);
		
		em.persist(s);
		
		tx.commit();
		em.close();
	}

	void createAPerson() {
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		System.out.println("Creating a person embedding an address:");

		tx.begin();

		Person p = new Person();
//		p.setId(2);
		p.setFirstName("Mihrimah");
		p.setLastName("Kaldiroglu");

		Address a = new Address();
		a.setStreet("Gul Mahallesi, Cicek Sokak");
		a.setAppt("77");
		a.setCity("Izmir");
		a.setZipCode("12345");
		p.setAddress(a);
		
		em.persist(p);
		
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
