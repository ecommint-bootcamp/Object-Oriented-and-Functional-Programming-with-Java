package org.javaturk.jpa.ch05.one2many.list.bidirection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.javaturk.jpa.util.PersistenceUtil;

import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("personOneToManyBiList");
//		PersistenceUtil.turnOnEclipseLinkWeaving(true);
	}

	public static void main(String[] args) {
		Test test = new Test();

//		 test.createPersonWithCar();
//		 
//		Person person = test.retrievePersonByQuery();
		Person person = test.retrievePerson();
		System.out.println("Person retrieved: " + person);
		List<Car> cars = person.getCars();
		System.out.println(cars.size());  // In EclipseLink this line causes to fetch the lazy fields data from DB
//		if (cars == null)
//			System.out.println("Null list");
//		else {
//			System.out.println("Here are the cars");
//			for (Car car : cars)
//				System.out.println(car);
//		}

		// System.out.println(person);
//		 test.retrieveAllCars();
//		test.deletePersonWithCar();
//		 test.retrieveAllPersons();
//		test.removeOrphan();
	}

	void createPersonWithCar() {
		System.out.println("Creating a person with a car.");
		EntityManager em = PersistenceUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person owner1 = new Person("Mihrimah", "Kaldiroglu");
		Car car1 = new Car("Mercedes", "C200", "2010");
		Car car2 = new Car("Ferrari", "F360", "2008");
		Car car3 = new Car("Haci Murat", " ", "1978");
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
		Car car4 = new Car("Renault", "Megan", "2001");
		Car car5 = new Car("Opel", "Astra", "2004");
		Car car6 = new Car("Skoda", "Fabia", "2006");
		owner2.addCar(car4);
		// car4.setOwner(owner2);
		owner2.addCar(car5);
		// car5.setOwner(owner2);
		owner2.addCar(car6);
//		car6.setOwner(owner2);

		// If cascade=PERSIST isn't used non of the cars are persisted
		// but owner is persisted because it is a 1-N association

		em.persist(owner2);

		tx.commit();
		em.close();
	}

	private Person retrievePerson() {
		EntityManager em = PersistenceUtil.getEntityManager();

		Person owner = em.find(Person.class, 11);

		List<Car> cars = owner.getCars();
		cars.size();
		em.close();

		return owner;
	}
	
	/**
	 * A helper method with a trick that fetches cars of a person eagerly.
	 * @return
	 */
	private Person retrievePersonWithcars() {
		EntityManager em = PersistenceUtil.getEntityManager();

		Person owner = em.find(Person.class, 11);
		List<Car> cars = owner.getCars();
		cars.size();

		em.close();
		return owner;
	}

	private Person retrievePersonByQuery() {
		EntityManager em = PersistenceUtil.getEntityManager();

//		TypedQuery<Person> query = em.createQuery("Select p from Person p Where p.id = 1", Person.class);
		Query query = em.createQuery("Select p from Person p Where p.id = 5");
		Person owner = (Person) query.getSingleResult();
//		owner.getCars().size();    // Initialize the list in EclipseLink otherwise it prints {IndirectList: not instantiated}
		em.close();
		return owner;
	}

	private void deletePersonWithCar() {
		System.out.println("\nDeleting a person with a car: ");
		EntityManager em = PersistenceUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person owner = em.find(Person.class, 5);
//		List<Car> cars = owner.getCars();
//		Iterator<Car> it = cars.iterator();
//		while(it.hasNext()) {
//			Car c = it.next();
//			c.setOwner(null);
//			it.remove();
//		}
//		for (Car car : cars) {
//			car.setOwner(null);
//			owner.deleteCar(car);
//		}

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
//		System.out.println(cars.size() + " objects:");

		// for (Car car : cars){
		// Person owner = car.getOwner();
		// System.out.println(owner);
		// }

		for (Car car : cars) {
//			System.out.println(car);
			Person owner = car.getOwner();
			System.out.println("Owner: " + owner);
		}
		em.close();
	}

	private void removeOrphan() {
		EntityManager em = PersistenceUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person owner = em.find(Person.class, 7);
		List<Car> cars = owner.getCars();
		Iterator<Car> it = cars.iterator();
		while(it.hasNext()) {
			Car c = it.next();
			c.setOwner(null);
			it.remove();
		}

		tx.commit();
		em.close();
	}
}
