package org.javaturk.jpa.ch06.mappedSuperclass;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {
	
	public Test() {
		PersistenceUtil.setPersistenceUnitName("personInheritanceMappedSuperclass");
	}

	public static void main(String[] args) {
		Test test = new Test();

//		test.createPeople();
//		test.retrieveAllPersons();
//		test.retrieveAllEmployees();
		test.retrieveAllConsultants();
//		test.editConsultant();
//		test.retrieveAPerson(4);
		
		PersistenceUtil.close();
	}

	void createPeople() {
		System.out.println("Creating people");
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
//		Person p = new Person();
//		p.setFirstName("Mihrimah");
//		p.setLastName("Kaldiroglu");
		
//		Can't do it
//		em.persist(p);

		Employee e1 = new Employee("Ali", "Ozturk", "Production", 5);
		em.persist(e1);

		Employee e2 = new Employee("Fatma", "Sonmez", "Production", 7);
		em.persist(e2);

		Employee e3 = new Employee("Onder", "Ala", "Sales", 12);
		em.persist(e3);
		
		Consultant c1 = new Consultant("Akin", "Kaldiroglu", 1500);
		em.persist(c1);

		Manager m1 = new Manager("Aysegul", "Peri", "Production", "Production", 7);
		em.persist(m1);

		Manager m2 = new Manager("Mahmut", "Oncu", "Sales", "Sales", 17);
		em.persist(m2);

		Director d = new Director("Selim", "Turk", "Management", "Management", 22);
		em.persist(d);

		tx.commit();
		em.close();
	}

	private void retrieveAPerson(int i) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Person person = em.find(Person.class, i);
		System.out.println(person);
	}
	
	public void retrieveAllPersons() {
		System.out.println("\nAll of the persons: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allPersons = em.createQuery("Select p from Person p");
		Collection<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");

		for (Person person : persons)
			System.out.println(person);
		em.close();
	}
	
	public void retrieveAllEmployees() {
		System.out.println("\nAll of the persons: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allEmployees = em.createQuery("Select e from Employee e");
		Collection<Employee> employees = allEmployees.getResultList();
		System.out.println(employees.size() + " objects:");

		for (Employee e : employees)
			System.out.println(e);
		em.close();
	}
	
	private void retrieveAllConsultants() {
		System.out.println("\nAll of the consultants: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allConsultants = em.createQuery("Select c from Consultant c");
		Collection<Consultant> consultants = allConsultants.getResultList();
		System.out.println(consultants.size() + " objects:");

		for (Consultant consultant : consultants)
			System.out.println(consultant);
		em.close();
	}
	
	private void editConsultant() {
		System.out.println("\nEditing a consultants: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Consultant consultant = em.find(Consultant.class, 5);
		consultant.setNumberOfDays(8);
		tx.commit();
		em.close();
	}
}
