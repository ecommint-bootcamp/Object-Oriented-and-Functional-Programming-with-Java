package org.javaturk.jpa.ch02;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;
import static org.javaturk.jpa.util.Factory.createId;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("entity");
	}

	public static void main(String[] args) {
		Test test = new Test();
		
//		test.createPersonUsingEntityManagerFactory();
//		test.createPersonUsingPersistenceUtil();
//		test.createPersonWithoutTX();

//		test.createPerson();
		test.createPersons(1000);
//	 	test.retrieveAPerson(382439984);
//		test.retrieveAllPersons();
//		test.retrievePersonWithGivenLastnameUsingQuery("Telli");
		test.retrievePersonWithGivenLastnameUsingNamedQuery("Telli");
		
//		Person p = test.editPerson(17398);
//		p.setFirstName(p.getFirstName() + "X");
//		test.updatePerson(p);
		
		PersistenceUtil.close();
	}
	
	public void updatePerson(Person p) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		
		Person pMerged = em.merge(p);
		
		pMerged.setLastName("XXXXX");
		
		p.setLastName("YYYYY");
		
		tx.commit();
		em.close();
	}

	
	
	public Person editPerson(int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		
		Person p = em.find(Person.class, id);
		if(p != null)
			System.out.println("Person retrieved: " + p);
		
//		p.setLastName(p.getLastName() + "X");
		
		
		tx.commit();
		em.close();
		
		
//		p.setFirstName(p.getFirstName() + "X");
//		
//		 em = PersistenceUtil.getEntityManager();
//		 tx = em.getTransaction();
//
//		tx.begin();
//		
//		tx.commit();
//		em.close();
		
		return p;
	}

	/**
	 * This method uses <code>Persistence.createEntityManagerFactory(String persistentUnitName)</code> to create
	 * <code>EntityManagerfactory</code>, which in turn creates <code>EntityManager<code>."
	 * For this example the properties in persistence.xml should not be commented err, they should be in effect.
	 */
	void createPersonUsingEntityManagerFactory(){
		System.err.println("Creating a person with a transaction using EntityManagerFactory.");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("entity");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Person p = new Person();
		p.setId(createId());
		p.setFirstName("Mihrimah");
		p.setLastName("Kaldiroglu");
		System.out.println("Persisting: " + p);

		em.persist(p);
		tx.commit();
		em.close();
	}
	
	/**
	 * This method uses <code>org.javaturk.jpa.util.PersistenceUtil</code> to create
	 * <code>EntityManager<code>."
	 * For this example the properties in persistence.xml are not used, they can be commented err.
	 * The properties in jpa.properties file are used by <code>PersistenceUtil</code>.
	 */
	void createPersonUsingPersistenceUtil() {
		System.err.println("Creating a person with a transaction using PersistenceUtil.");
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Person p = new Person();
		p.setId(createId());
		p.setFirstName("Selim");
		p.setLastName("Ozgur");
		System.err.println("Persisting: " + p);

		em.persist(p);
		tx.commit();
		em.close();
	}
	
	void createPersonWithoutTX() {
		System.err.println("Creating a person without a transaction.");
		EntityManager em = PersistenceUtil.getEntityManager();

		Person p = new Person();
		p.setId(101010101);
		p.setFirstName("Mihrimah");
		p.setLastName("Kaldiroglu");

		em.persist(p);
		em.close();
	}
	
	void createPersons(int n) {
		System.err.println("Creating " + n + " persons.");
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person p = null;
		for (int i = 0; i < n; i++) {
			p = Factory.createPerson();
			em.persist(p);
		}
		
		tx.commit();
		em.close();
	}
	
	private void retrieveAPerson(int id) {
		System.err.println("\nRetrieving the person with id: " + id);
		EntityManager em = PersistenceUtil.getEntityManager();

		Person person = em.find(Person.class, id);
		if (person == null)
			System.out.println("No such person!");
		else
			System.out.println("\n" + person);
		em.close();  
	}
	
	public void retrieveAllPersons() {
		System.err.println("\nRetrieving all of the persons: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allPersons = em.createQuery("Select p from PERSON_ENTITY p");
		Collection<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");

		for (Person person : persons)
			System.out.println(person);
		
		em.close();
	}
	
	private void retrievePersonWithGivenLastnameUsingQuery(String lastName) {
		System.err.println("Retrieving all persons with given last name: " + lastName);
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("Select p from PERSON_ENTITY p where p.lastName='" + lastName + "'");
		Collection<Person> persons = query.getResultList();
		System.err.println(persons.size() + " objects:");

		for (Person person : persons)
			System.out.println(person);
		em.close();
	}
	
	private void retrievePersonWithGivenLastnameUsingNamedQuery(String lastName) {
		System.err.println("Retrieving all persons with given last name: " + lastName + " (using a named query).");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createNamedQuery("Person.findByLastname");
		query.setParameter("lname", lastName);
		Collection<Person> persons = query.getResultList();
		System.out.println(persons.size() + " objects:");

		for (Person person : persons)
			System.out.println(person);
		em.close();
	}
}
