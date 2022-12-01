package org.javaturk.jpa.ch05.fetch;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("personBasicFetch");
	}

	public static void main(String[] args) {
		Test test = new Test();

		test.createPerson();

//		test.retrieveAllPersons();
		
//		Person person = test.fetchPerson(5);
//		System.out.println(person);
		
//		test.retrieveAllPersons();
//		test.retrieveAPerson(1);
	}

	void createPerson() {
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();

		Person p = new Person();
		p.setFirstName("Mihrimah");
		p.setLastName("Kaldiroglu");
		p.setRate(new BigDecimal("44.12"));
		p.setSalary(new BigDecimal("3672.24"));
		Car car = new Car(1, "Mercedes", "C200", "2010");
		p.setCar(car);
		
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

	public Person retrieveAPerson(int id) {
		System.out.println("\nFetching a person: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Person person = em.find(Person.class, id);
		return person;
	}
}
