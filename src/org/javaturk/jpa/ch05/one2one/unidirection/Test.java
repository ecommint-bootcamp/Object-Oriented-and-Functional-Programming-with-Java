package org.javaturk.jpa.ch05.one2one.unidirection;

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
		PersistenceUtil.setPersistenceUnitName("personOneToOneUni");
	}

	public static void main(String[] args) {
		Test test = new Test();
		
		test.createPersonWithCar();
//		test.createPersonWithoutCar();
//		test.retrieveAPerson();
//		test.retrieveAllPersons();
//		test.deletePerson();
//		test.removeOrphan();
//		test.removeCar();

	}

	/**
	 * Unless Person-Car relationship is borken, a Person's car can not be deleted: DB gives following error:
	 * DELETE on table 'CARONE2ONEUNIDIR' caused a violation of foreign key constraint.
	 */
	private void removeCar1() {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Car c = em.find(Car.class, 222);
		em.remove(c);
		
		tx.commit();
		em.close();
		
	}

	void createPersonWithCar() {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Person owner1 = new Person(11112, "Mihrimah", "Kaldiroglu");
		Car car1 = new Car(111112, "Mercedes", "C200", "2010");
		owner1.setCar(car1);
		em.persist(owner1);
		
		Person owner2 = new Person(22222, "Akin", "Kaldiroglu");
		Car car2 = new Car(222222, "Ferrari", "F430", "2014");
		owner2.setCar(car2);
		em.persist(owner2);
		
//		em.persist(car1);
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
		
		Person owner = new Person(1, "Mihrimah", "Kaldiroglu");
		em.persist(owner);
		
		Person owner2 = new Person(2, "Akin", "Kaldiroglu");
		em.persist(owner2);
		
		Car car1 = new Car(11, "Mercedes", "C200", "2010");
		Car car2 = new Car(22, "Ferrari", "F430", "2014");
		
		em.persist(car1);
		em.persist(car2);
		
		tx.commit();
		em.close();
	}
	
	public void retrieveAPerson() {
		System.out.println("\nRetrieving a person: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Person p = em.find(Person.class, 111);
		
		em.close();	
		
//		Car car = p.getCar();
//		System.out.println(car);
	}
	
	public void retrieveAPersonWithCar() {
		System.out.println("\nRetrieving a person: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Person p = em.find(Person.class, 111);
		Car car = p.getCar();
		car.getId();
		em.close();	
		
//		Car car = p.getCar();
//		System.out.println(car);
	}
	
	public void retrieveAllPersons() {
		System.out.println("\nAll of the persons: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allPersons = em.createQuery("Select p from Person p");
		Collection<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");
		em.close();

//		Person person1 = (Person) ((List) persons).get(0);
//		Car car = person1.getCar();
//		car.getMake();
//		System.out.println(car.getClass().getName());
//		
//		for (Person person : persons)
//			System.out.println(person);
//		em.close();
//		Car car = person1.getCar();
//		System.out.println(car.getClass().getName());
//		System.out.println(car.getClass().getName());
		for (Person person : persons)
			System.out.println(person);	
	}
	
	private void deletePerson() {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Person p = em.find(Person.class, 22);
		em.remove(p);
		
		tx.commit();
		em.close();
	}
	
	private void removeOrphan() {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Person p = em.find(Person.class, 11112);
		System.out.println(p);
		Car car = p.getCar();
		System.out.println(car);
		
		//Break the relationship with car
		p.setCar(null);
		
		tx.commit();
		em.close();
	}
	
	private void removeCar() {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Person p = em.find(Person.class, 1111);
		Car c = p.getCar();
		p.setCar(null);
		em.remove(c);
		Car c1 = p.getCar();
		System.out.println(c1);
		tx.commit();
		em.close();
		
	}
}