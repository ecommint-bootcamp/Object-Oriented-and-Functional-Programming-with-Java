package org.javaturk.jpa.ch13.plain.di;

import java.util.Collection;

import javax.persistence.*;

import org.javaturk.jpa.util.PersistenceUtil;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The most simple case for JPA integration. EntityManagerFactory is injected as a property Test1 class.
 * Persistent unit name is declared in Spring configuration XML.
 */
public class Test1 {
//	private static ApplicationContext ctx = null;
//
//	private EntityManagerFactory entityManagerFactory = null;
//	
//	private EntityManager manager = null;
//	
//	public static void main(String[] args) {
//		ctx = new ClassPathXmlApplicationContext("org/javaturk/jpa/ch13/plain/di/application1.xml");
//		Test1 test = (Test1) ctx.getBean("test1");
//		
//		test.createPersons(100);
////		test.retrieveAPerson(1969530325);
//	}
//	
//	/**
//	 * EntityManagerFactory is injected as a property
//	 * @param entityManagerFactory
//	 */
//	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
//		this.entityManagerFactory = entityManagerFactory;
//	}
//	
//	void createPersons(int n) {
//		System.out.println("\nCreating " + n + " persons");
//		EntityManager em = entityManagerFactory.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//
//		Person p = null;
//		for (int i = 0; i < n; i++) {
//			p = Factory.createPerson();
//			em.persist(p);
//		}
//		
//		tx.commit();
//		em.close();
//	}
//	
//	private void retrieveAPerson(int id) {
//		System.out.println("\nRetrieving the person with id: " + id);
//		EntityManager em = entityManagerFactory.createEntityManager();
//		Person person = em.find(Person.class, id);
//		em.close();	
//		System.out.println(person);
//	}
}