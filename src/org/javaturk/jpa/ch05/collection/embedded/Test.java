package org.javaturk.jpa.ch05.collection.embedded;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

/**
 * Run this example using lazy loading Address objects with Hibernate to see its effect.
 * @author akin
 *
 */
public class Test {
	private EntityManagerFactory entityManagerFactory;

	public Test() {
		PersistenceUtil.setPersistenceUnitName("collection.embedded");
	}

	public static void main(String[] args) {
		Test test = new Test();

//		test.createAPersonAndAStudent();
		test.retrieveAllPersons();

	}

	void createAPersonAndAStudent() {
		EntityManager em = PersistenceUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();
		System.out.println("Creating a person and a student embedding an address:");

		tx.begin();

		Person p = new Person(1, "Mihrimah", "Kaldiroglu");

		Address a1 = new Address();
		a1.setStreet("Gul Mahallesi, Cicek Sokak");
		a1.setAppt("77");
		a1.setCity("Izmir");
		a1.setZipCode("12345");
		p.addAddress(a1);

		Address a2 = new Address();
		a2.setStreet("Sen Mahallesi, Alabora Sokak");
		a2.setAppt("14");
		a2.setCity("Balikesir");
		a2.setZipCode("10191");
		p.addAddress(a2);

		Address a3 = new Address();
		a3.setStreet("Baca Mahallesi, Sen Sokak");
		a3.setAppt("5");
		a3.setCity("Balikesir");
		a3.setZipCode("98765");
		p.addAddress(a3);

		em.persist(p);

		Student s = new Student();
		s.setId(222);
		s.setFirstName("Akin");
		s.setLastName("Kaldiroglu");

		Address a4 = new Address();
		a4.setStreet("Sefa Caddesi, 17. Sokak");
		a4.setAppt("59");
		a4.setCity("Ayvalik");
		a4.setZipCode("10400");
		s.addAddress(a4);

		Address a5 = new Address();
		a5.setStreet("Arslan Caddesi, 1. Sokak");
		a5.setAppt("22");
		a5.setCity("Ayvalik");
		a5.setZipCode("10400");
		s.addAddress(a5);

		em.persist(s);

		tx.commit();
		em.close();
	}

	public void retrieveAllPersons() {
		System.out.println("\nAll of the persons: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allPersons = em.createQuery("Select p from Person p");
		Collection<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");

//		em.close();

		for (Person person : persons) {
			System.out.println(person);
			System.out.println("Adresses:");
			Set<Address> addresses = person.getAddresses();
			Iterator i = addresses.iterator();
			while (i.hasNext())
				System.out.println(i.next());

//		em.close();
		}
	}
}
