package org.javaturk.jpa.ch05.one2one.bidirection;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("personOneToOneBi");
//		PersistenceUtil.turnOnEclipseLinkWeaving(false);
		// -javaagent:/Users/akin/Java/Lib/eclipselink/jlib/eclipselink.jar
		// For Hibernate https://docs.jboss.org/hibernate/orm/5.1/userguide/html_single/chapters/pc/BytecodeEnhancement.html
		//                http://devdoc.net/javaweb/hibernate/Hibernate-5.1.0/userGuide/en-US/html/ch03.html
	}

	public static void main(String[] args) throws InterruptedException {
		Test test = new Test();

//		test.createPersonWithCar();
//		test.createPersonWithoutCar();
		Person person = test.retrievePerson();
//		Thread.sleep(5000);
		System.out.println("Person: " + person);
		Car car = person.getCar();
		System.out.println("Car: " + car);
		
//		test.retrieveAllPersons();
//		test.deletePersonWithCar();
//		test.retrieveAllPersons();
//		test.removeOrphan();
		
		
		PersistenceUtil.close();
	}
	
	void createPersonWithCar() {
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Person owner1 = new Person("Mihrimah", "Kaldiroglu");
		Car car1 = new Car("MercedesX", "C200", "2010");
		owner1.setCar(car1);
		car1.setOwner(owner1);
		
		em.persist(owner1);
//		Don'T need this when Cascade.PERSIST exists
//		em.persist(car1);
		
		
		Person owner2 = new Person("Selim", "Temiz");
		Car car2 = new Car("VWY", "Passat", "2010");
		owner2.setCar(car2);
		car2.setOwner(owner2);
		
		em.persist(owner2);
//		em.persist(car2);
		
		tx.commit();
		em.close();
	}
	
	/**
	 * To see the effect of "optional"
	 * @author akin
	 */
	void createPersonWithoutCar() {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Person owner1 = new Person("Kamil", "Ozgur");
		em.persist(owner1);
		
		Person owner2 = new Person("Selcan", "Temiz");
		em.persist(owner2);
		
		Car car1 = new Car("Bentley", "b8", "2016");
		em.persist(car1);
		
		Car car2 = new Car("Aston Martin", "A2", "2016");
		em.persist(car2);
		
		tx.commit();
		em.close();
	}

	private Person retrievePerson() {
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
//		tx.begin();
		Person owner = em.find(Person.class, 1);
//		System.out.println(owner);
//		tx.commit();
//		em.close();
		return owner;
	}

	private void removeOrphan() {
		System.out.println("\nDeleting a person with a car: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person owner = em.find(Person.class, 53);
		Car car = owner.getCar();
		car.setOwner(null);
		owner.setCar(null);
		
		tx.commit();
		em.close();
		
	}

	private void deletePersonWithCar() {
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person owner = em.find(Person.class, 3);
		Car car = owner.getCar();
		car.setOwner(null);
		owner.setCar(null);
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
		for (Person person : persons)
			System.out.println(person);
	}
}
