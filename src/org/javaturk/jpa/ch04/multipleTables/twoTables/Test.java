package org.javaturk.jpa.ch04.multipleTables.twoTables;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("twoTables");
	}

	public static void main(String[] args) {
		Test test = new Test();

		test.createPerson();
//		test.retrieveAllPersons();
	}

	void createPerson() {
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();

		Person p = new Person();
		p.setFirstName("Mihrimah");
		p.setLastName("Kaldiroglu");	
		p.setRate(new BigDecimal("44.1245"));
		p.setSalary(new BigDecimal("3672.24"));
		
		//Secondary table properties
		p.setStreet("Cumhuriyet Cad.");
		p.setAppt("17");
		p.setCity("Ayvalik");
		p.setZipCode("10400");
		
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
}
