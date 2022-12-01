package org.javaturk.jpa.ch04.id.table;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;


public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("tableGenerator");
	}

	public static void main(String[] args) {
		Test test = new Test();
		
		test.createPersonAndStudentByTable();
//		test.retrieveAllPersons();
	}

	private void createPersonAndStudentByTable() {
		System.out.println("Creating a person and a student with an id by table");
		EntityManager em = PersistenceUtil.getEntityManager();	
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person p1 = new Person("Mihrimah", "Kaldiroglu");		
		em.persist(p1);
		
		Person p2 = new Person("Selim", "Ay");		
		em.persist(p2);
		
		Person p3 = new Person("Berrin", "Tuna");		
		em.persist(p3);
		
		Student s1 = new Student("Fatma", "Pinar");		
		em.persist(s1);
		
		Student s2 = new Student("Bulent", "Turk");		
		em.persist(s2);
		
		Student s3 = new Student("Zeynep", "Ak");		
		em.persist(s3);
		
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
