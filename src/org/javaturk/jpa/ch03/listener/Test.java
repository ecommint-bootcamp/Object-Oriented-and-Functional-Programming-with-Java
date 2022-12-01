package org.javaturk.jpa.ch03.listener;

import java.util.ArrayList;
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
		PersistenceUtil.setPersistenceUnitName("listener");
	}

	public static void main(String[] args) {
		Test test = new Test();

		test.createPersonsWithCars();
//		test.deletePerson();
//		test.addCarToAPerson();
//		test.mergeAPerson();
//		test.editAPerson();
//		test.sellACar();
//		test.retrieveAllPersons();
		
//		List<Person> persons = test.fetchAllPersons();
//		for (Person person : persons)
//			System.out.println(person);
		
//		test.retrieveAllCars();
		
//		List<Car> cars = test.fetchAllCars();
//		for (Car car : cars)
//			System.out.println(car);
		
//		test.deletePersonWithCar();
//		test.retrieveAllPersons();
	}

	void createPersonsWithCars() {
		System.out.println("Creating persons with many cars.");
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
		
		em.persist(car1);
		em.persist(car2);
		em.persist(car3);
		em.persist(car4);
		em.persist(car5);
		em.persist(car6);
		
		
		owner1.addCar(car1);
		car1.addOwner(owner1);
		
		owner1.addCar(car2);
		car2.addOwner(owner1);
		owner1.addCar(car3);
		car3.addOwner(owner1);
		owner1.addCar(car4);
		car4.addOwner(owner1);
		owner1.addCar(car5);
		car5.addOwner(owner1);
		
		owner2.addCar(car1);
		car1.addOwner(owner2);
		owner2.addCar(car2);
		car2.addOwner(owner2);
		owner2.addCar(car4);
		car4.addOwner(owner2);
		owner2.addCar(car5);
		car5.addOwner(owner2);
		
		owner3.addCar(car6);
		car6.addOwner(owner3);
		
		//If cascade=PERSIST isn't used non of the cars are persisted
		//but owner is persisted because it is a 1-N association
		em.persist(owner1);
		em.persist(owner2);
		em.persist(owner3);
		
		tx.commit();
		em.close();
	}

	public void addCarToAPerson(){
		System.out.println("\nAdding a car to a person: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person person = em.find(Person.class, 7);
		Car car = em.find(Car.class, 4);
		person.addCar(car);
//		car.addOwner(person);
		tx.commit();
		em.close();		
	}
	
	public void sellACar(){
		System.out.println("\nSelling a car :) ");
		EntityManager em = PersistenceUtil.getEntityManager();		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person person = em.find(Person.class, 7);
		Car car = em.find(Car.class, 4);
		
		person.deleteCar(car);
		car.deleteOwner(person);
		
		tx.commit();
		em.close();
	}

	private void mergeAPerson() {
		System.out.println("Updating a person.");
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person person = em.find(Person.class, 7);
		tx.commit();
		em.close();
		
		//Detached Person and new Car
		Car car = new Car("BMW", "7.45", "2010");
		person.addCar(car);
		car.addOwner(person);
		
		//Merge it back
		em = PersistenceUtil.getEntityManager();
		tx = em.getTransaction();
		tx.begin();
		em.persist(car);
		em.merge(person);
		tx.commit();
		em.close();
		
	}
	
	public void editAPerson(){
		System.out.println("Updating a person.");
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person person = em.find(Person.class, 7);
		person.setLastName("XXX");
		tx.commit();
		em.close();
	}
	
	private void deletePerson() {
		System.out.println("\nDeleting a person: ");
		EntityManager em = PersistenceUtil.getEntityManager();		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person owner = em.find(Person.class, 9);
//		owner.setCars(new ArrayList());
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
	
	public void retrieveAllCars() {
		System.out.println("\nAll of the cars: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allCars = em.createQuery("Select c from Car c");
		Collection<Car> cars = allCars.getResultList();
		
		//Don't retrieve persons unless they are loaded eagerly.
		System.out.println(cars.size() + " objects:");
		for (Car car : cars)
			System.out.println(car);
		em.close();
	}
	
	public List fetchAllCars() {
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
