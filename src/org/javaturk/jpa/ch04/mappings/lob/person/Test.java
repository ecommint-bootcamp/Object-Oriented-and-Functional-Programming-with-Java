package org.javaturk.jpa.ch04.mappings.lob.person;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("lob");
	}

	public static void main(String[] args) {
		Test test = new Test();

//		 test.createPerson();

		Person person = test.retrieveAPerson(2);
		System.out.println(person.getClass().getName());
		System.out.println(person.getId());
		System.out.println(person.getFirstName());
		System.out.println(person.getLastName());
		byte[] picture = person.getPicture();
		System.out.println("Size of picture: " + picture.length);
		System.out.println(picture[1025]);

		// test.retrieveAllPersons();

	}

	void createPerson() {

		EntityManager em = PersistenceUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();
		System.out.println("Creating a person with a transaction");

		tx.begin();

		Person p = new Person();
		p.setId(2);
		p.setFirstName("Mihrimah");
		p.setLastName("Kaldiroglu");
		for (int i = 0; i < p.picture.length; i++)
			p.picture[i] = (byte) i;
		
		char[] cv = new char[1_000_000_000];
		for (int i = 0; i < cv.length; i++)
			cv[i] = (char) i;
		p.cv = cv.toString();

		em.persist(p);

		tx.commit();
		em.close();
	}

	private Person retrieveAPerson(int id) {
		System.out.println("\nRetrieving the person with id: " + id);
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person person = em.find(Person.class, id);
//		Person person = em.getReference(Person.class, id);
		
		System.out.println(person.getId());
//		System.out.println(person.getFirstName());
//		System.out.println(person.getLastName());
//		byte[] picture = person.getPicture();
//		System.out.println("Size of picture: " + picture.length);
//		System.out.println(picture[1025]);
		System.out.println("================================");
		// if (person == null)
		// System.out.println("No such person!");
		// else
		// System.out.println("\n" + person);
		tx.commit();
		em.close();

		return person;
	}

	public void retrieveAllPersons() {
		System.out.println("\nAll of the persons: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allPersons = em.createQuery("from Person");
		// Query allPersons =
		// em.createQuery("Select p from CH02.entity.Person p where p.lastName='Pasa'");
		Collection<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");

		for (Person person : persons)
			System.out.println(person);
		em.close();
	}
}
