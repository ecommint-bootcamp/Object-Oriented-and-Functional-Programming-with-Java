package org.javaturk.jpa.ch14.lazyCollection;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("performance");
	}

	public static void main(String[] args) {
		Test test = new Test();
		String nString = JOptionPane.showInputDialog("Please hit OK!");
		
//		 test.createPersonWithCar();
//		 

//		test.repeatRetrievePerson(100);
//		test.repeatRetrievePersonByInitializingCarListByCallingSize(100);
	
		Person person = test.retrievePerson();
//		Person person = test.retrievePersonByInitializingCarListByCallingSize();
		
//		List<Car> cars = person.getCars();
//		if (cars == null)
//			System.out.println("Null list");
//		else {
//			System.out.println("Here are the cars");
//			for (Car car : cars)
//				System.out.println(car);
//		}
		// System.out.println(person);
		// test.retrieveAllPersons();
	}

	void createPersonWithCar() {
		System.out.println("Creating a person with a car.");
		EntityManager em = PersistenceUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person owner1 = new Person("Mihrimah", "Kaldiroglu");
		
		Car car11 = new Car("Mercedes1", "C200", "2010");
		Car car12 = new Car("Ferrari1", "F360", "2008");
		Car car13 = new Car("Haci Murat1", " ", "1978");
		owner1.addCar1(car11);
		owner1.addCar1(car12);
		owner1.addCar1(car13);
		
		Car car21 = new Car("Mercedes2", "C200", "2010");
		Car car22 = new Car("Ferrari2", "F360", "2008");
		Car car23 = new Car("Haci Murat2", " ", "1978");
		owner1.addCar2(car21);
		owner1.addCar2(car22);
		owner1.addCar2(car23);
		
		Car car31 = new Car("Mercedes3", "C200", "2010");
		Car car32 = new Car("Ferrari3", "F360", "2008");
		Car car33 = new Car("Haci Murat3", " ", "1978");
		owner1.addCar3(car31);
		owner1.addCar3(car32);
		owner1.addCar3(car33);
		
		Car car41 = new Car("Mercedes4", "C200", "2010");
		Car car42 = new Car("Ferrari4", "F360", "2008");
		Car car43 = new Car("Haci Murat4", " ", "1978");
		owner1.addCar4(car41);
		owner1.addCar4(car42);
		owner1.addCar4(car43);
		
		Car car51 = new Car("Mercedes5", "C200", "2010");
		Car car52 = new Car("Ferrari5", "F360", "2008");
		Car car53 = new Car("Haci Murat5", " ", "1978");
		owner1.addCar1(car51);
		owner1.addCar1(car52);
		owner1.addCar1(car53);

		// If cascade=PERSIST isn't used non of the cars are persisted
		// but owner is persisted because it is a 1-N association
		em.persist(owner1);

		tx.commit();
		em.close();
	}
	
	public void repeatRetrievePerson(int n){
		long start = System.currentTimeMillis();
		for(int i = 0; i < n; i++){
			retrievePerson();
		}
		long end = System.currentTimeMillis();
		System.out.println("Time for repeatRetrievePerson(): "  + (end-start) + " ms.");
	}
	
	public void repeatRetrievePersonByInitializingCarListByCallingSize(int n){
		long start = System.currentTimeMillis();
		for(int i = 0; i < n; i++){
			retrievePersonByInitializingCarListByCallingSize();
		}
		long end = System.currentTimeMillis();
		System.out.println("Time for retrievePersonByInitializingCarListByCallingSize(): "  + (end-start) + " ms.");
	}
	
	private Person retrievePerson() {
		System.out.println("in retrievePerson()");
		EntityManager em = PersistenceUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();
		long start = System.currentTimeMillis();
		tx.begin();
		Person owner = em.find(Person.class, 1);
		List<Car> cars1 = owner.getCars1();
		List<Car> cars2 = owner.getCars2();
		List<Car> cars3 = owner.getCars3();
		List<Car> cars4 = owner.getCars4();
		List<Car> cars5 = owner.getCars5();
		tx.commit();
		long end = System.currentTimeMillis();
		em.close();
		System.out.println("Time for retrievePerson(): "  + (end-start) + "ms.");
		return owner;
	}
	
	private Person retrievePersonByInitializingCarListByCallingSize() {
		System.out.println("in retrievePersonByInitializingCarListByCallingSize()");
		EntityManager em = PersistenceUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();
		long start = System.currentTimeMillis();
		tx.begin();
		Person owner = em.find(Person.class, 1);
		List<Car> cars1 = owner.getCars1();
		List<Car> cars2 = owner.getCars2();
		List<Car> cars3 = owner.getCars3();
		List<Car> cars4 = owner.getCars4();
		List<Car> cars5 = owner.getCars5();
		cars1.size();
		cars2.size();
		cars3.size();
		cars4.size();
		cars5.size();
		tx.commit();
		long end = System.currentTimeMillis();
		em.close();
		System.out.println("Time for retrievePersonByInitializingCarListByCallingSize(): "  + (end-start) + "ms.");
		return owner;
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
}
