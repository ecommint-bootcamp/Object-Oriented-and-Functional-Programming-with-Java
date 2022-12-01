package org.javaturk.jpa.ch08.entity.factory;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import static org.javaturk.jpa.util.PersistenceUtil.*;

public class Test {

	public Test() {
		setPersistenceUnitName("query");
	}

	public static void main(String[] args) {
		Test test = new Test();
//		test.populate();
//		test.retrieveAllProjectsWithMoreThatGivenTasks(2);
		test.retrieveAllProjectsWithATaskAssignedToGivenEmployee("Sonmez");

	}

	public void retrieveAllProjectsWithMoreThatGivenTasks(int taskCount) {
		System.out.println("\nProjects with at least " + taskCount + "tasks." );
		EntityManager em = getEntityManager();
		Query projectsQuery = em.createQuery("Select p from Project p Where size(p.tasks) > " + taskCount);
		Collection<Project> projects = projectsQuery.getResultList();
		System.out.println(projects.size() + " objects:");
		for (Project p : projects)
			System.out.println(p);
		em.close();
	}
	
	private void retrieveAllProjectsWithATaskAssignedToGivenEmployee(String lastname) {
		System.out.println("\nProjects with a task assigned to an employee with given lastname: " + lastname );
		EntityManager em = getEntityManager();
//		Query projectsQuery = em.createQuery("Select e from Employee e Where e.lastName = " + lastname);
		Query projectsQuery = em.createQuery("Select p from Project p Employee e Where e.lastName MEMBER OF ( Select e1 from Employee e1 Where e1.lastName = " + lastname + " )");
		Collection<Project> projects = projectsQuery.getResultList();
		System.out.println(projects.size() + " objects:");
		for (Project p : projects)
			System.out.println(p);
		em.close();
	}

	private void populate() {
		EntityManager em = getEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Project p1 = new Project("Small Java Project", 5);
		
		Task t1 = new Task("Task-1");
		p1.addTask(t1);
		Task t2 = new Task("Task-2");
		p1.addTask(t2);
		Task t3 = new Task("Task-3");
		p1.addTask(t3);
		Task t4 = new Task("Task-4");
		p1.addTask(t4);
		Task t5 = new Task("Task-5");
		p1.addTask(t5);
		
		Project p2 = new Project("Big Java Project", 10);
		
		Task t6 = new Task("Task-6");
		p2.addTask(t6);
		Task t7 = new Task("Task-7");
		p2.addTask(t7);
		Task t8 = new Task("Task-8");
		p2.addTask(t8);
		Task t9 = new Task("Task-9");
		p2.addTask(t9);
		Task t10 = new Task("Task-10");
		p2.addTask(t10);
		Task t11 = new Task("Task-11");
		p2.addTask(t11);
		Task t12 = new Task("Task-12");
		p2.addTask(t12);
		
		Employee e1 = new Employee("Ali", "Ozturk", "Production", 5);
		p1.addEmployee(e1);
		e1.assign(t1);
		e1.assign(t2);
		e1.assign(t3);
		
		p2.addEmployee(e1);
		e1.assign(t6);

		Employee e2 = new Employee("Fatma", "Sonmez", "Production", 7);
		p1.addEmployee(e2);
		e2.assign(t4);
		e2.assign(t5);
		
		p2.addEmployee(e2);
		e2.assign(t7);
		e2.assign(t8);
		e2.assign(t9);
		

		Employee e3 = new Employee("Onder", "Ala", "Sales", 12);
		p2.addEmployee(e3);
		
		Consultant c1 = new Consultant("Akin", "Kaldiroglu", 2000);
		p1.setConsultant(c1);
		
		
		Consultant c2 = new Consultant("Metin", "Korkmaz", 3000);
		p2.setConsultant(c2);

		Manager m1 = new Manager("Aysegul", "Peri", "Production", "Production", 7);
		p1.addEmployee(m1);
		m1.setProjectManaged(p1);
		p2.addEmployee(m1);
		m1.assign(t10);

		Manager m2 = new Manager("Mahmut", "Oncu", "Sales", "Sales", 17);
		p2.addEmployee(m2);
		m2.setProjectManaged(p2);
		m2.assign(t11);
		em.persist(m2);

		Director d = new Director("Selim", "Turk", "Management", "Management", 22);
		p2.addEmployee(d);
		d.assign(t12);
		
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		
		em.persist(m1);
		em.persist(m2);
		
		em.persist(c1);
		em.persist(c2);
		
		em.persist(d);
		
		em.persist(p1);
		em.persist(p2);

		tx.commit();
		em.close();
	}

	void createPersonWithCar() {
		EntityManager em = getEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person owner1 = new Person("Mihrimah", "Kaldiroglu");
		Car car1 = new Car("Mercedes", "C200", "2010");
		owner1.setCar(car1);
		car1.setOwner(owner1);
		em.persist(owner1);
		// Don'T need this when Cascade.PERSIST exists
		em.persist(car1);

		Person owner2 = new Person("Selim", "Temiz");
		Car car2 = new Car("VW", "Passat", "2010");
		// owner2.setCar(car2);
		car2.setOwner(owner2);
		em.persist(owner2);
		em.persist(car2);

		tx.commit();
		em.close();
	}

	private Person retrievePerson() {
		EntityManager em = getEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person owner = em.find(Person.class, 3);
		// System.out.println(owner);
		tx.commit();
		em.close();
		return owner;
	}

	public void retrieveAllPersons() {
		System.out.println("\nAll of the persons: ");
		EntityManager em = getEntityManager();
		Query allPersons = em.createQuery("Select p from Person p");
		Collection<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");
		for (Person person : persons)
			System.out.println(person);
		em.close();
	}
}
