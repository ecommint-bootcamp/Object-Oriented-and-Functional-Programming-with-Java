package org.javaturk.jpa.ch03.emf;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Test {
	private EntityManagerFactory emf1;
	private EntityManagerFactory emf2;

	public Test() {
		emf1 = Persistence.createEntityManagerFactory("emf");
		emf2 = Persistence.createEntityManagerFactory("emf");
	}

	public static void main(String[] args) {
		Test test = new Test();

//		 test.createPerson();
		 test.retrievePersonWithID(51);

	}

	void createPerson() {
		EntityManager em1 = emf1.createEntityManager();
		EntityTransaction tx1 = em1.getTransaction();

		tx1.begin();

		Person p1 = new Person();
		p1.setFirstName("Sami");
		p1.setLastName("Khedira");
		em1.persist(p1);
		tx1.commit();
		
		
		EntityManager em2 = emf2.createEntityManager();
		EntityTransaction tx2 = em2.getTransaction();

		tx2.begin();

		Person p2 = new Person();
		p2.setFirstName("Ahmet");
		p2.setLastName("Zorlu");
		em2.persist(p2);
		tx2.commit();
		
		em1.close();
		em2.close();
		
	}

	public void retrievePersonWithID(int id) {
		System.out.println("\nPerson with id " + id);

		EntityManager em1 = emf1.createEntityManager();
		EntityTransaction tx1 = em1.getTransaction();

		tx1.begin();
		
		Person person1 = em1.find(Person.class, id);
		System.out.println(person1);

		em1.close();
		
		EntityManager em2 = emf2.createEntityManager();
		EntityTransaction tx2 = em2.getTransaction();

		tx2.begin();
		
		Person person2 = em2.find(Person.class, id);
		System.out.println(person2);

		em2.close();
	}
}
