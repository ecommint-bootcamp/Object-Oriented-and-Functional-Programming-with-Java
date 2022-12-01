package org.javaturk.jpa.ch13.plain.di;

import java.util.Collection;

import javax.persistence.*;

import org.javaturk.jpa.util.PersistenceUtil;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * EntityManagerFactory is injected as a property Test2 class. 
 * Injection is achieved through annotation, @PersistenceUnit(unitName = "springPlain1")
 * Persistent unit name does not need to be declared in Spring configuration XML.
 */
public class Test2 {
//	private static ApplicationContext ctx = null;
//	
//	@PersistenceUnit(unitName = "springPlain1")
//	private EntityManagerFactory entityManagerFactory = null;
//	
//	public static void main(String[] args) {
//		ctx = new ClassPathXmlApplicationContext("org/javaturk/jpa/ch13/plain/di/application1.xml");
//		Test2 test = (Test2) ctx.getBean("test2");
//		
//		test.createPersons(100);
////		test.retrieveAPerson(1969530325);
//	}
//	
////	@PersistenceUnit(unitName = "springPlain1")
////	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
////		this.entityManagerFactory = entityManagerFactory;
////	}
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
////		if (person == null)
////			System.out.println("No such person!");
////		else
////			System.out.println("\n" + person);
//		em.close();
//		
//		System.out.println(person);
//	}
}
