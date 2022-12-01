package org.javaturk.jpa.ch03.em;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class FlushTest extends Test{

	public static void main(String[] args) {
		FlushTest test = new FlushTest();
//		test.flush(18);
		test.refreshAndFlush(252);
	}
	
	private void flush(int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.setFlushMode(javax.persistence.FlushModeType.COMMIT);
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person person = em.find(Person.class, id);
		System.err.println("Person fetched: " + person);
		person.setLastName(person.getFirstName() + random.nextInt(1000));
		System.err.println("Updated person: " + person);
		
//		em.flush();
		
		Query query = em.createQuery("Select p from Person p");
		Collection<Person> persons = query.getResultList();
		for(Person p : persons)
			System.out.println(p);
		
//		Person person2 = em.find(Person.class, id);
//		System.out.println(person2);
		
//		em.flush();

//		try {
//			Thread.sleep(20000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		em.refresh(person);
		System.out.println(person);
		tx.commit();
		em.close();
	}
	
	private void refreshAndFlush(int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.setFlushMode(javax.persistence.FlushModeType.COMMIT);
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person person = em.find(Person.class, id);
		System.out.println(person);
		person.setLastName("NNN");
		System.out.println(person);
		
//		em.flush();
		Query query = em.createQuery("Select p from Person p");
		// Set flush mode type and see its effect
//		query.setFlushMode(javax.persistence.FlushModeType.AUTO);
		Collection<Person> persons = query.getResultList();
		for(Person p : persons)
			System.out.println(p);
		
//		Person person2 = em.find(Person.class, id);
//		System.out.println(person2);
		
//		em.flush();

//		try {
//			Thread.sleep(20000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		em.refresh(person);
		System.out.println(person);
		tx.commit();
		em.close();
	}

}
