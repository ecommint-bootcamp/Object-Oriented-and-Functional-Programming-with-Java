package org.javaturk.jpa.ch04.id.sequence;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

/*
 * 
 * CREATE SEQUENCE   "PERSONIDSEQUENCE"  
 MINVALUE 1 
 MAXVALUE 999999999999999999999999999 
 INCREMENT BY 1 
 START WITH 1 CACHE 2

 To use a sequence manually in an insert statement

 insert into PersonIdentitySequence values(PERSONIDSEQUENCE.nextVal, 'Ali', 'Veli');

 select PERSONIDSEQUENCE.NEXTVAL from DUAL; that gets the next value from the sequence

 /
 */
public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("sequence");
	}

	public static void main(String[] args) {
		Test test = new Test();

		test.createPersonBySequence();
		// test.retrieveAllPersons();
	}

	private void createPersonBySequence() {
		System.out.println("Creating a person with an id by sequence");
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		for (int i = 0; i < 200; i++) {
			Person p1 = new Person("Mihrimah", "Kaldiroglu");
			em.persist(p1);
		}
//		
//		 Person p2 = new Person("Selim", "Ay");
//		 em.persist(p2);
		
//		 Person p3 = new Person("Mehmet", "Salim");
//		 em.persist(p3);

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
