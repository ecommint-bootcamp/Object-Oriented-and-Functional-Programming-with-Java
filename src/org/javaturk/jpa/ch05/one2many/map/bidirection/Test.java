package org.javaturk.jpa.ch05.one2many.map.bidirection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("personOneToManyMapBi");
	}

	public static void main(String[] args) {
		Test test = new Test();

//		test.createPersonWithCar();
		
		Person person = test.retrievePerson();
		System.out.println(person);
		Map<Integer, Car> cars = person.getCars();
		if (cars == null)
			System.out.println("Null list");
		else {
			System.out.println("Here are the cars");
			Set<Integer> ids = cars.keySet();
			
			for (Integer i : ids){
				Car car = cars.get(i);
				System.out.println(car);
			}
		}
		// test.retrieveAllCars();
		// test.deletePersonWithCar();
		// test.retrieveAllPersons();
		// test.removeOrphan();
	}

	void createPersonWithCar() {
		System.out.println("Creating a person with a car.");
		EntityManager em = PersistenceUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person owner1 = new Person("Mihrimah", "Kaldiroglu");
		Car car1 = new Car(1, "Mercedes", "C200", "2010");
		Car car2 = new Car(2, "Ferrari", "F360", "2008");
		Car car3 = new Car(3, "Haci Murat", " ", "1978");
		owner1.addCar(car1);
		// car1.setOwner(owner1);
		owner1.addCar(car2);
		// car2.setOwner(owner1);
		owner1.addCar(car3);
		// car3.setOwner(owner1);

		// If cascade=PERSIST isn't used non of the cars are persisted
		// but owner is persisted because it is a 1-N association
		em.persist(owner1);

		Person owner2 = new Person("Ali", "Seymen");
		Car car4 = new Car(4, "Renault", "Megan", "2001");
		Car car5 = new Car(5, "Opel", "Astra", "2004");
		Car car6 = new Car(6, "Skoda", "Fabia", "2006");
		owner2.addCar(car4);
		// car4.setOwner(owner2);
		owner2.addCar(car5);
		// car5.setOwner(owner2);
		owner2.addCar(car6);
		car6.setOwner(owner2);

		// If cascade=PERSIST isn't used non of the cars are persisted
		// but owner is persisted because it is a 1-N association
		em.persist(owner2);

		tx.commit();
		em.close();
	}
	
	private Person retrievePerson() {
		EntityManager em = PersistenceUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person owner = em.find(Person.class, 1);
		// List<Car> cars = owner.getCars();
		// for (Car car : cars) {
		// Car newCar = car;
		// }
		// System.out.println(owner);
		tx.commit();
		em.close();
		return owner;
	}

	private void deletePersonWithCar() {
		System.out.println("\nDeleting a person with a car: ");
		EntityManager em = PersistenceUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person owner = em.find(Person.class, 1);
		Map<Integer, Car> cars = owner.getCars();
		// for (Car car : cars) {
		// car.setOwner(null);
		// // owner.deleteCar(car);
		// }

		em.remove(owner);
		tx.commit();
		em.close();
	}

	public void retrieveAllPersons() {
		System.out.println("\nAll of the persons: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allPersons = em.createQuery("Select p from Person p");
		Collection<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");

		// for (Person person : persons)
		// System.out.println(person);

		// for (Person person : persons){
		// List<Car> cars = person.getCars();
		// Car car = cars.get(0);
		// }
		em.close();

		for (Person person : persons)
			System.out.println(person);
	}

	public void retrieveAllCars() {
		System.out.println("\nAll of the cars: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allCars = em.createQuery("Select c from Car c");
		Collection<Car> cars = allCars.getResultList();
		System.out.println(cars.size() + " objects:");

		// for (Car car : cars){
		// Person owner = car.getOwner();
		// System.out.println(owner);
		// }
		em.close();

		for (Car car : cars) {
			Person owner = car.getOwner();
			System.out.println(owner);
		}
	}

	private void removeOrphan() {
		EntityManager em = PersistenceUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person owner = em.find(Person.class, 4);
		Map<Integer, Car> cars = owner.getCars();

//		Object[] objects = cars.toArray();
//
//		for (Object o : objects) {
//			Car car = (Car) o;
//			car.setOwner(null);
//			cars.remove(car);
//		}

		tx.commit();
		em.close();
	}
}
