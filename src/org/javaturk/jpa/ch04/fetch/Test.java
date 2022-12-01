package org.javaturk.jpa.ch04.fetch;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

/**
 * For EclipseLink to see the effect of lazy loading run this class as
 * -javaagent:/Users/akin/Java/Lib/eclipselink/2.7.7/jlib/eclipselink.jar
 * 
 * It should be a VM argument.
 * 
 * @author akin
 *
 */
public class Test {

	private EntityManagerFactory entityManagerFactory;

	public Test() {
		PersistenceUtil.setPersistenceUnitName("fetch");
//		PersistenceUtil.turnOnEclipseLinkWeaving(true);
	}

	public static void main(String[] args) {
		Test test = new Test();

//		test.createPerson();
//		test.createPersons(100);

		Person p = test.retrieveAPerson(1);
		System.out.println("---- Person ---");
		System.out.println(p.getFirstName());
		System.out.println(p.getLastName());
		System.out.println(p);

//	 	test.retrieveAllPersons();
	}

	void createPerson() {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		System.out.println("Creating a person with a transaction");

		tx.begin();

		Person p = new Person();
		p.setId(1);
		p.setFirstName("Mihrimah");
		p.setLastName("Kaldiroglu");

		em.persist(p);

		tx.commit();
		em.close();
	}

	void createPersons(int n) {
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

	private Person retrieveAPerson(int id) {
		System.out.println("\nRetrieving the person with id: " + id);
		EntityManager em = PersistenceUtil.getEntityManager();

		Person person = em.find(Person.class, id);
//		em.detach(person);
//		em.clear();
		em.close();
//		System.out.println(person.getClass().getName());

//		if (person == null)
//			System.out.println("No such person!");
//		else
//			System.out.println("\n" + person);
		return person;
	}

	private Person retrieveAPersonByQuery(int id) {
		System.out.println("\nRetrieving the person with id: " + id);
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("Select p from PersonFetch p Where p.id = " + id);
		Person person = (Person) query.getSingleResult();
		em.close();
		return person;
	}

	public void retrieveAllPersons() {
		System.out.println("\nAll of the persons: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allPersons = em.createQuery("Select p from PersonFetch p");
		Collection<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");
		em.close();

		for (Person person : persons)
			System.out.println(person);

	}
}
