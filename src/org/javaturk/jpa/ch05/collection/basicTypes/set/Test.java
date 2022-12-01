package org.javaturk.jpa.ch05.collection.basicTypes.set;

import java.util.Collection;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("collection.basicTypesSet");
	}

	public static void main(String[] args) {
		Test test = new Test();

		test.createPerson();
//		test.retrieveAPerson(33); // See the effect of using @OrderBy and TreeSet
//		test.retrieveAllPersons();

	}

	void createPerson() {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Person p = new Person();
		p.setId(2);
		p.setFirstName("Mihrimah");
		p.setLastName("Kaldiroglu");
		
		p.addPhone("222-222-2222");
		p.addPhone("111-111-1111");
		p.addPhone("333-333-3333");
//		This won't be inserted into the set
		boolean b = p.addPhone("111-111-1111");
		System.out.println(b);

		em.persist(p);

		tx.commit();
		em.close();
	}
	
	private void retrieveAPerson(int id) {
		System.out.println("\nRetrieving the person with id: " + id);
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person person = em.find(Person.class, id);
		if (person == null)
			System.out.println("No such person!");
		else
			System.out.println("\n" + person);
		
		Set<String> phones = person.getPhones();
		for(String phone:phones)
			System.out.println(phone);
		
		person.addPhone("000-000-0000");
		tx.commit();
		em.close();
	}
	
	public void retrieveAllPersons() {
		System.out.println("\nAll of the persons: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allPersons = em.createQuery("from Person");
		Collection<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");

		for (Person person : persons)
			System.out.println(person);
		em.close();
	}
}
