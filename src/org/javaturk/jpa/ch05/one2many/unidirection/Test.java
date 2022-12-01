package org.javaturk.jpa.ch05.one2many.unidirection;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Test {
	private EntityManagerFactory entityManagerFactory;

	public Test() {
		entityManagerFactory = Persistence.createEntityManagerFactory("personOne2ManyUniDir");
	}

	public static void main(String[] args) {
		Test test = new Test();

		test.createPersonWithCar();
//		test.retrieveAllPersons();
//		test.deletePersonWithCar();
//		test.retrieveAllPersons();
	}

	void createPersonWithCar() {
		System.out.println("Creating a person with a car.");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Person owner1 = new Person("Mihrimah", "Kaldiroglu");
		Car car1 = new Car("Mercedes", "C200", "2010");
		Car car2 = new Car("Ferrari", "F360", "2008");
		Car car3 = new Car("Haci Murat", " ", "1078");
		owner1.addCar(car1);
		owner1.addCar(car2);
		owner1.addCar(car3);
		
		//If cascade=PERSIST isn'T used non of the cars are persisted
		//but owner is persisted because it is a 1-N association
		em.persist(owner1);
		
		Person owner2 = new Person("Ali", "seymen");
		Car car4 = new Car("Renault", "Megan", "2001");
		Car car5 = new Car("Opel", "Astra", "2004");
		Car car6 = new Car("Skoda", "Fabia", "2006");
		owner2.addCar(car4);
		owner2.addCar(car5);
		owner2.addCar(car6);
		
		//If cascade=PERSIST isn't used non of the cars are persisted
		//but owner is persisted because it is a 1-N association
		em.persist(owner2);
		
		tx.commit();
		em.close();
	}

	private void deletePersonWithCar() {
		System.out.println("\nDeleting a person with a car: ");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person owner = em.find(Person.class, 1);
		em.remove(owner);
		tx.commit();
		em.close();
	}
	
	public void retrieveAllPersons() {
		System.out.println("\nAll of the persons: ");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query allPersons = em.createQuery("Select p from Person p");
		Collection<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");
		for (Person person : persons)
			System.out.println(person);
		em.close();
	}
}
