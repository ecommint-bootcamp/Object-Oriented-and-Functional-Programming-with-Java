package org.javaturk.jpa.ch05.many2many.unidirection;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("personBasicFetch");
	}

	public static void main(String[] args) {
		Test test = new Test();

		test.createPersonsWithCars();
//		test.retrieveAllPersons();
		
		List<Person> persons = test.fetchAllPersons();
		for (Person person : persons)
			System.out.println(person);
		
//		test.retrieveAllCars();
		
//		List<Car> cars = test.fetchAllCars();
//		for (Car car : cars)
//			System.out.println(car);
		
//		test.deletePersonWithCar();
//		test.retrieveAllPersons();
	}

	void createPersonsWithCars() {
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Person owner1 = new Person("Mihrimah", "Kaldiroglu");
		Person owner2 = new Person("Ali", "Seymen");
		Person owner3 = new Person("Betul", "Kibar");
		
		Car car1 = new Car("Mercedes", "C200", "2010");
		Car car2 = new Car("Ferrari", "F360", "2008");
		Car car3 = new Car("Haci Murat", " ", "1078");
		Car car4 = new Car("Renault", "Megan", "2001");
		Car car5 = new Car("Opel", "Astra", "2004");
		Car car6 = new Car("Skoda", "Fabia", "2006");
		
		
		owner1.addCar(car1);
		owner1.addCar(car2);
		owner1.addCar(car3);
		owner1.addCar(car4);
		owner1.addCar(car5);
		
		owner2.addCar(car1);
		owner2.addCar(car2);
		owner2.addCar(car4);
		owner2.addCar(car5);
		
		owner3.addCar(car6);
		
		//If cascade=PERSIST isn't used non of the cars are persisted
		//but owner is persisted because it is a 1-N association
		em.persist(owner1);
		em.persist(owner2);
		em.persist(owner3);
		
		tx.commit();
		em.close();
	}

	private void deletePersonWithCar() {
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person owner = em.find(Person.class, 1);
		em.remove(owner);
		tx.commit();
		em.close();
	}
	
	public void retrieveAllPersons() {
		System.out.println("\nAll of the persons: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Query allPersons = em.createQuery("Select p from Person p");
		Collection<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");
		
		//Don't retrieve cars unless they are loaded eagerly.
		for (Person person : persons)
			System.out.println(person);
		
		tx.commit();
		em.close();
	}
	
	public List fetchAllPersons() {
		System.out.println("\nAll of the persons: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Query allPersons = em.createQuery("Select p from Person p");
		List<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");
		tx.commit();
		em.close();
		
		return persons;
	}
	
	public List retrieveAllCars() {
		System.out.println("\nAll of the cars: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Query allPersons = em.createQuery("Select c from Car c");
		List<Car> cars = allPersons.getResultList();
		System.out.println(cars.size() + " objects:");
		tx.commit();
		em.close();
		
		return cars;
	}
}
