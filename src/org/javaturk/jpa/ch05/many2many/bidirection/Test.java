package org.javaturk.jpa.ch05.many2many.bidirection;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

/**
 * -javaagent:/Users/akin/Java/Lib/eclipselink/jlib/eclipselink.jar
 * @author akin
 *
 */
public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("personManyToManyListBi");
	}

	public static void main(String[] args) {
		Test test = new Test();

//		test.createPersonsWithCars();
//		test.addCarToAPerson();
		test.sellACar();
//		test.retrieveAllPersons();
		
//		List<Person> persons = test.fetchAllPersons();
//		for (Person person : persons)
//			System.out.println(person);
		
//		test.retrieveAllCars();
		
//		List<Car> cars = test.retrieveAllCars();
//		for (Car car : cars) {
//			System.out.println(car);
//			List<Person> owners = car.getOwners();
//			System.out.println("Owners");
//			for(Person p : owners)
//				System.out.println(p);
//		}
//		
//		test.deletePerson();
//		test.deletePersonWithCar();
//		test.retrieveAllPersons();
		
		PersistenceUtil.close();
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
		//but owner is persisted because it is a M-N association
		em.persist(owner1);
		em.persist(owner2);
		em.persist(owner3);
		
//		What would happen if no cascading is done?
		
//		em.persist(car1);
//		em.persist(car2);
//		em.persist(car3);
//		em.persist(car4);
//		em.persist(car5);
//		em.persist(car6);
		
		tx.commit();
		em.close();
	}

	public void addCarToAPerson(){
		System.out.println("\nAdding a car to a person: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person person = em.find(Person.class, 15);
		Car car = em.find(Car.class, 23);
		person.addCar(car);
		car.addOwner(person);
		tx.commit();
		em.close();		
	}
	
	public void sellACar(){
		System.out.println("\nSelling a car :) ");
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person owner = em.find(Person.class, 17);
		Car car = em.find(Car.class, 20);
		
		owner.deleteCar(car);
		car.deleteOwner(owner);
		
		Person newOwner = em.find(Person.class, 22);
		newOwner.addCar(car);
		car.addOwner(newOwner);
		
		tx.commit();
		em.close();
	}
	
	private void deletePerson() {
		System.out.println("\nDeleting a person: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person owner = em.find(Person.class, 15);
		em.remove(owner);
		
		tx.commit();
		em.close();
	}
	
	private void deletePersonWithCar() {
		System.out.println("\nDeleting a person with a car: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person owner = em.find(Person.class, 15);
		owner.removeAllCars();
		em.remove(owner);
		
		tx.commit();
		em.close();
	}
	
	public void retrieveAllPersons() {
		System.out.println("\nAll of the persons: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		
		Query allPersons = em.createQuery("Select p from Person p");
		Collection<Person> persons = allPersons.getResultList();
		em.close();
		
		System.out.println(persons.size() + " objects:");
		
		//Don't retrieve cars unless they are loaded eagerly.
		for (Person person : persons) {
			System.out.println(person);
			List<Car> cars = person.getCars();
			for(Car car : cars)
				System.out.println(car);
		}
		
		
//		//Don't retrieve cars unless they are loaded eagerly.
//		for (Person person : persons)
//			System.out.println(person);
	}
	
	public List retrieveAllCars() {
		System.out.println("\nAll of the cars: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allCars = em.createQuery("Select c from Car c");
		List<Car> cars = allCars.getResultList();
		
		//Don't retrieve persons unless they are loaded eagerly.
//		System.out.println(cars.size() + " objects:");
//		for (Car car : cars)
//			System.out.println(car);
		em.close();
		return cars;
	}
}
