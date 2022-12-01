package org.javaturk.jpa.ch03.em;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Query;

import org.hibernate.FlushMode;
import org.javaturk.jpa.util.PersistenceUtil;

public class Test {
	protected Random random = new Random();

	public Test() {
		PersistenceUtil.setPersistenceUnitName("em");
	}

	public static void main(String[] args) {
		Test test = new Test();

//		 test.retrievePersonWithID(111111);
		// test.retrievePersonWithQuery(1);
		// test.retrievePersonWithIDUsingNamedQuery(1);
		// test.retrievePersonsWithSpecifiedNameUsingNQ("Cem", "Telli");
		// test.retrieveAllPersons();
		// test.getReference(188);
		
		// test.getDelegate();
//		 test.isOpen();
		// test.findAndGetReference(2);
		 
		 PersistenceUtil.close();
	}



	private void findAndGetReference(int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// Person person1 = em.find(Person.class, id);
		// System.out.println(person1);
		// Person person2 = em.find(Person.class, id);
		// System.out.println(person2);
		// Person person3 = em.find(Person.class, id);
		// System.out.println(person3);

		Person personReference = em.getReference(Person.class, 2);
		System.out.println("AFTER GETREFERENCE");
		personReference.setLastName("TTTTT");
		// System.out.println(personReference);

		tx.commit();
		em.close();

	}

	public void retrievePersonWithID(int id) {
		System.out.println("\nPerson with id " + id);
		EntityManager em = PersistenceUtil.getEntityManager();
		Person person = em.find(Person.class, id);
		
		if(person != null)
			System.out.println(person.getFirstName());

		// EntityTransaction tx = em.getTransaction();

		// tx.begin();
		// tx.commit();
		em.close();
	}

	private void retrievePersonWithQuery(int id) {
		System.out.println("\nPerson with id " + id);
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("Select p From Person p where p.id=" + id);
		Person person = (Person) query.getSingleResult();
		System.out.println(person);

		// EntityTransaction tx = em.getTransaction();
		//
		// tx.begin();
		// tx.commit();
		em.close();
	}

	public void retrievePersonWithIDUsingNamedQuery(int id) {
		System.out.println("\nPerson with id " + id + " using NQ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allPersons = em.createNamedQuery("findById");
		allPersons.setParameter("id", id);
		Person person = (Person) allPersons.getSingleResult();
		System.out.println(person);
		em.close();
	}

	public void retrievePersonsWithSpecifiedNameUsingNQ(String firstName, String lastName) {
		System.out.println("\nPersons whose names are " + firstName + " " + lastName + " using NQ: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allPersonsSpecifiedName = em.createNamedQuery("findPersonWithSpecifiedName");
		allPersonsSpecifiedName.setParameter("firstName", firstName);
		allPersonsSpecifiedName.setParameter("lastName", lastName);
		Collection<Person> persons = allPersonsSpecifiedName.getResultList();
		System.out.println(persons.size() + " objects:");
		for (Person person : persons)
			System.out.println(person);
		em.close();
	}

	public void retrieveAllPersons() {
		System.out.println("\nAll of the persons: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allPersons = em.createQuery("from Person");
		Collection<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");
		for (Person person : persons)
			System.out.println(person);
		em.close();
	}

	private void getReference(int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Person person = em.getReference(Person.class, id);
		// System.out.println(person);
		System.out.println(person.getClass().getName());

		tx.commit();
		em.close();

		System.out.println(person);
	}

	public void editPerson() {
		System.out.println("\nEditing persons: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query personsWithZaferLastname = em.createQuery("Select p from Person p Where p.lastName='Zafer'");

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Collection<Person> persons = personsWithZaferLastname.getResultList();
		System.out.println(persons.size() + " objects:");
		for (Person person : persons) {
			person.setLastName(person.getLastName() + 'X');
		}

		tx.commit();
		em.close();
	}

	private void getDelegate() {
		EntityManager em = PersistenceUtil.getEntityManager();
		System.out.println(em.getDelegate().getClass().getName());
	}

	private void isOpen() {
		EntityManager em = PersistenceUtil.getEntityManager();
		System.out.println(em.isOpen());
		em.close();
		System.out.println(em.isOpen());
	}
}
