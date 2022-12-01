package org.javaturk.jpa.ch05.collection.basicTypes.map;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("collection.basicTypesMap");
	}

	public static void main(String[] args) {
		Test test = new Test();

		test.createPerson();
		test.retrieveAPerson(35);
//		test.retrieveAllPersons();

	}

	void createPerson() {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Person p = new Person();
		p.setId(35);
		p.setFirstName("Mihrimah");
		p.setLastName("Kaldiroglu");
		
		p.addPhone("111-111-1111");
		p.addPhone("222-222-2222");
		p.addPhone("333-333-3333");
		p.addPhone("111-111-1111");

		em.persist(p);
		
		Person p1 = new Person();
		p1.setId(34);
		p1.setFirstName("Zeynep");
		p1.setLastName("Buyuk");
		
		p1.addPhone("111-111-1111");
		p1.addPhone("222-222-2222");
		p1.addPhone("333-333-3333");
		p1.addPhone("111-111-1111");

		em.persist(p1);

		tx.commit();
		em.close();
	}
	
	private void retrieveAPerson(int id) {
		System.out.println("\nRetrieving the person with id: " + id);
		EntityManager em = PersistenceUtil.getEntityManager();

		Person person = em.find(Person.class, id);
		
		em.close();
		if (person == null)
			System.out.println("No such person!");
		else
			System.out.println("\n" + person);
		
		System.out.println("Phones");
		Map<Integer, String> phones = person.getPhones();
		Set<Integer> phoneIndeces = phones.keySet();
		for(Integer phoneIndex:phoneIndeces){
			String phone = phones.get(phoneIndex);
			System.out.println(phoneIndex + " - " + phone);
		}
	}
	
	public void retrieveAllPersons() {
		System.out.println("\nAll of the persons: ");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allPersons = em.createQuery("Select p from Person p");
		Collection<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");

		for (Person person : persons) {
			System.out.println(person);
			Map<Integer, String> phoneMap = person.getPhones();
			Set<Integer> keys = phoneMap.keySet();
			Iterator<Integer> keyIterator = keys.iterator();
			while(keyIterator.hasNext())
				System.out.println(phoneMap.get(keyIterator.next()));
		}
		em.close();
	}
}
