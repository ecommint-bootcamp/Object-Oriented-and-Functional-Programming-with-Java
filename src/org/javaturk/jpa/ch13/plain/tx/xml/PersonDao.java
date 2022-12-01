
package org.javaturk.jpa.ch13.plain.tx.xml;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;

public class PersonDao implements PersonDaoI{
//	@Autowired
	private LogDaoI logDao;

	@PersistenceContext(unitName="springPlainTxXml")
	private EntityManager em;


	public void createPersonWithCar(boolean problem) {
		System.out.println("Creating many persons with cars.");
		
		Person owner1 = new Person("Mihrimah", "Kaldiroglu");
		Car car1 = new Car("Mercedes", "C200", "2010");
		Car car2 = new Car("Ferrari", "F360", "2008");
		Car car3 = new Car("Haci Murat", " ", "1978");
		owner1.addCar(car1);
		owner1.addCar(car2);
		owner1.addCar(car3);
		
		//If cascade=PERSIST isn't used non of the cars are persisted
		//but owner is persisted because it is a 1-N association
		em.persist(owner1);
		
		Person owner2 = new Person("Ali", "Seymen");
		Car car4 = new Car("Renault", "Megan", "2001");
		Car car5 = new Car("Opel", "Astra", "2004");
		Car car6 = new Car("Skoda", "Fabia", "2006");
		owner2.addCar(car4);
		owner2.addCar(car5);
		owner2.addCar(car6);
		
		//If cascade=PERSIST isn't used non of the cars are persisted
		//but owner is persisted because it is a 1-N association
		em.persist(owner2);
		
		if(problem){
			logDao.log(owner1 + " is NOT persisted.");
			logDao.log(owner2 + " is NOT persisted.");
			throw new RuntimeException("Probleeeeemmmm!");
		}
		else{
			logDao.log(owner1 + " is persisted.");
			logDao.log(owner2 + " is persisted.");
		}
	}

	public void deletePersonWithCar() {
		System.out.println("\nDeleting a person with a car: ");
		Person owner = em.find(Person.class, 1);
		em.remove(owner);
		logDao.log(owner + " is removed.");
	}
	
	public void retrieveAllPersons() {
		System.out.println("\nAll of the persons: ");
		Query allPersons = em.createQuery("Select p from Person p");
		Collection<Person> persons = allPersons.getResultList();
		logDao.log("All persons are retrieved.");
		System.out.println(persons.size() + " objects:");
		
		for (Person person : persons){
			List<Car> cars = person.getCars();
			Car car = cars.get(0);
		}
		
		for (Person person : persons)
			System.out.println(person);
	}
	
	public void retrieveAllCars() {
		System.out.println("\nAll of the cars: ");
		Query allCars = em.createQuery("Select c from Car c");
		Collection<Car> cars = allCars.getResultList();
		logDao.log("All cars are retrieved.");
		System.out.println(cars.size() + " objects:");
		
		for (Car car : cars){
			Person owner = car.getOwner();
			System.out.println(owner);
		}
	}
}

