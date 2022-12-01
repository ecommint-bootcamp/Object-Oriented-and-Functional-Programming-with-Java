package org.javaturk.jpa.ch04.id.composite2;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;


public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("composite2");
	}

	public static void main(String[] args) {
		Test test = new Test();
		
		test.createPersonWithCompositeIdentity();
		test.retrievePerson();
//		test.retrieveAllPersons();
	}

	private void createPersonWithCompositeIdentity() {
		System.out.println("Creating a person with a composite id");
		EntityManager em = PersistenceUtil.getEntityManager();		
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Name name1 = new Name("Mihrimah", "Kaldiroglu");
		Person p1 = new Person(name1);		
		em.persist(p1);
		
		Name name2 = new Name("Selim", "Ay");
		Person p2 = new Person(name2);		
		em.persist(p2);
		
//		Name name3 = new Name("Selim", "Ay");
//		Person p3 = new Person(name3);		
//		em.persist(p3);
		
		tx.commit();
		em.close();
	}
	
	public void retrievePerson(){
		EntityManager em = PersistenceUtil.getEntityManager();
		Person person = em.find(Person.class, new Name("Mihrimah", "Kaldiroglu"));
		System.out.println(person);
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
