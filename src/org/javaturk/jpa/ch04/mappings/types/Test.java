package org.javaturk.jpa.ch04.mappings.types;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("types");
	}

	public static void main(String[] args) {
		Test test = new Test();

		test.createPerson();
//		test.retrieveAPerson(1);
//		test.retrieveAllPersons();
	}

	void createPerson() {		
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Person p = new Person();
		p.setId(2);
		p.setName("Mihrimah Kaldiroglu");
		p.setBonus(1200.83);
		p.setAge(9);
		p.setMarried(false);
		p.setRate(9.99f);
		p.setSalary(1000L);
		p.setSex('f');
		p.setDob1(new java.util.Date());
		p.setDob2((new java.sql.Date(new java.util.Date().getTime())));

		em.persist(p);

		tx.commit();
		em.close();
	}
	
	private void retrieveAPerson(int id) {
		System.out.println("\nRetrieving the person with id: " + id);
		EntityManager em = PersistenceUtil.getEntityManager();

		Person person = em.find(Person.class, id);
		if (person == null)
			System.out.println("No such person!");
		else
			System.out.println("\n" + person);
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
}
