package org.javaturk.jpa.ch08.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.javaturk.jpa.ch08.oql.simple.Factory;
import org.javaturk.jpa.ch08.oql.simple.Person;
import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("criteria");
	}

	public static void main(String[] args) {
		Test test = new Test();
//		 test.createPersons(100);
//		test.getAllPersons();
//		 test.getPersonsWithLastname("Aslan");
//		 test.getPersonsWithFirstnameAndLastname("Etem", "Aslan");
		 test.getPersonsWithFirstnameOrLastname("Ahmet", "Aslan");
	}

	public void createPersons(int count) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		for (int i = 0; i < count; i++) {
			Person p = Factory.createPerson();
			em.persist(p);
		}

		tx.commit();
		em.close();
	}

	public void getAllPersons() {
		EntityManager em = PersistenceUtil.getEntityManager();
		CriteriaBuilder cbuilder = em.getEntityManagerFactory().getCriteriaBuilder();
		CriteriaQuery<Person> criteria = cbuilder.createQuery(Person.class);
		Root<Person> person = criteria.from(Person.class);
		// ---- Build criteria
		criteria.select(person);
		// ---- Create a query object from Criteria and perform query operation
		List<Person> persons = em.createQuery(criteria).getResultList();
		displayResults("All persons using Criteria API", persons);
	}

	public void getPersonsWithLastname(String lastname) {
		EntityManager em = PersistenceUtil.getEntityManager();
		CriteriaBuilder cbuilder = em.getEntityManagerFactory().getCriteriaBuilder();
		CriteriaQuery<Person> criteria = cbuilder.createQuery(Person.class);
		Root<Person> person = criteria.from(Person.class);
		// ---- Build criteria
		criteria.select(person);
		criteria.where(cbuilder.equal(person.get("lastName"), lastname));
		// ---- Create a query object from Criteria and perform query operation
		List<Person> personList = em.createQuery(criteria).getResultList();
		displayResults("Persons with given lastname using Criteria API", personList);
	}

	public void getPersonsWithFirstnameAndLastname(String firstname, String lastname) {
		EntityManager em = PersistenceUtil.getEntityManager();
		CriteriaBuilder cbuilder = em.getEntityManagerFactory().getCriteriaBuilder();
		CriteriaQuery<Person> criteria = cbuilder.createQuery(Person.class);
		Root<Person> person = criteria.from(Person.class);
		// ---- Build criteria
		criteria.select(person);
		Predicate predicate1 = cbuilder.equal(person.get("firstName"), firstname);
		Predicate predicate2 = cbuilder.equal(person.get("lastName"), lastname);
		criteria.where(cbuilder.and(predicate1, predicate2));

		// ---- Create a query object from Criteria and perform query operation
		List<Person> personList = em.createQuery(criteria).getResultList();
		displayResults("Persons with given firstname and lastname using Criteria API", personList);
	}

	public void getPersonsWithFirstnameOrLastname(String firstname, String lastname) {
		EntityManager em = PersistenceUtil.getEntityManager();
		CriteriaBuilder cbuilder = em.getEntityManagerFactory().getCriteriaBuilder();
		CriteriaQuery<Person> criteria = cbuilder.createQuery(Person.class);
		Root<Person> person = criteria.from(Person.class);
		// ---- Build criteria
		criteria.select(person);
		Predicate predicate1 = cbuilder.equal(person.get("firstName"), firstname);
		Predicate predicate2 = cbuilder.equal(person.get("lastName"), lastname);
		criteria.where(cbuilder.or(predicate1, predicate2));

		// ---- Create a query object from Criteria and perform query operation
		List<Person> personList = em.createQuery(criteria).getResultList();
		displayResults("Persons with given firstname or lastname using Criteria API", personList);
	}

	public void displayResults(String query, List<Person> list) {
		System.out.println("\n" + query);
		System.out.println(list.size() + " results.");
		int i = 1;
		for (Person p : list) {
			String string = String.format("%-5d %-12d %-10s %-10s %5d %8.2f", i, p.getId(), p.getFirstName(),
					p.getLastName(), p.getSalary(), p.getRate());
			System.out.println(string);
			i++;
		}
	}

	public void displayObjectResults(String query, List<Object> list) {
		System.out.println("\n" + query);
		System.out.println(list.size() + " results.");
		int i = 1;
		for (Object object : list) {
			Object[] o = (Object[]) object;
			for (Object x : o)
				System.out.printf("%10s", x);
			System.out.println();
			i++;
		}
	}

	public void displayLongResults(String query, List<Long> list) {
		System.out.println("\n" + query);
		System.out.println(list.size() + " results.");
		int i = 1;
		for (Long l : list) {
			System.out.println(l);
			i++;
		}
	}
}
