package org.javaturk.jpa.ch04.mappings.serializable;

import java.util.Collection;

import javax.persistence.*;
import org.javaturk.jpa.util.PersistenceUtil;


public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("serializable");
	}

	public static void main(String[] args) {
		Test test = new Test();

		test.createPersonWithCar();
		test.retrieveAllPersons();
	}

	void createPersonWithCar() {
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		
		Person p = new Person("Mihrimah", "Kaldiroglu");
		Car car = new Car(1, "Mercedes", "C200", "2010");
		p.setCar(car);
//		car.setOwner(p);
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
		
		em.close();
		
		for (Person person : persons)
			System.out.println(person);
	}
}
