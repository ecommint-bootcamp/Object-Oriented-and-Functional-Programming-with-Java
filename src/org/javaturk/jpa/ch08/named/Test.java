package org.javaturk.jpa.ch08.named;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.ch08.oql.simple.Factory;
import org.javaturk.jpa.ch08.oql.simple.Person;
import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("namedQuery");
	}

	public static void main(String[] args) {
		Test test = new Test();
//		test.createPersons(100);
//		test.getMinSalary();
		test.getEmployeeFirstameLastnameAndSalaryOnly();
//		test.getPersonWithSpecifiedName("Faruk", "Ceviz");
	}
	
	private void getPersonWithSpecifiedName(String fName, String lName) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createNamedQuery("Person.findPersonWithSpecifiedName");
		query.setParameter("firstName", fName);
		query.setParameter("lastName", lName);
		List<Person> objectList = query.getResultList();
		displayResults(query.toString(), objectList);
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

	public void getEmployeesWithLastname(String lastname) {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select * From PersonQuery Where lname=\'" + lastname + "\'";
		Query query = em.createNativeQuery(queryString, Person.class);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);
	}

	public void getEmployeesWithFirstnameAndLastname(String firstname, String lastname) {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select * From PersonQuery Where fname=\'" + firstname + "\' AND lname=\'" + lastname
				+ "\'";
		Query query = em.createNativeQuery(queryString, Person.class);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);
	}

	public void getEmployeesWithFirstnameOrLastname(String firstname, String lastname) {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select * From PersonQuery Where fName=\'" + firstname + "\' OR lName=\'" + lastname
				+ "\'";
		Query query = em.createNativeQuery(queryString, Person.class);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);
	}

	public void getEmployeesWithLastnameLike(String lastname) {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select * From PersonQuery Where lName LIKE \'" + lastname + "\'";
		Query query = em.createNativeQuery(queryString, Person.class);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);
	}

	public void getEmployeesWithLastnameIn() {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select * From PersonQuery P Where lName IN ('Esen', 'Aslan')";
		Query query = em.createNativeQuery(queryString, Person.class);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);
	}

	public void getEmployeesWithLastnameNotIn() {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select * From PersonQuery P Where lName NOT IN ('Aslan', 'Arabaci', 'Arabaci', 'Aslan', 'Aymaz', 'Ayna')";
		Query query = em.createNativeQuery(queryString, Person.class);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);
	}

	public void getEmployeesWithLastnameNotInWithRange(int start, int count) {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select * From PersonQuery P Where lName NOT IN ('Aslan', 'Arabaci', 'Arabaci', 'Aslan', 'Aymaz', 'Ayna')";
		Query query = em.createNativeQuery(queryString, Person.class);
		query.setFirstResult(start);
		query.setMaxResults(count);
		List<Person> personList = query.getResultList();
		// Person p= (Person) query.getSingleResult();
		// System.out.println(p);
		displayResults(queryString, personList);
	}

	public void getEmployeesWithSalaryOrderByFirstnameAndLastnameOrderBy(long base, long ceil) {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select * From PersonQuery  Where salary > " + base + " AND salary < " + ceil
				+ " ORDER BY salary DESC, lname ASC";
		Query query = em.createNativeQuery(queryString, Person.class);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);
	}

	public void getEmployeesWithSalaryOrderByFirstnameAndLastnameOrderByParametric(long base, long ceil) {
		EntityManager em = PersistenceUtil.getEntityManager();
		// String queryString =
		// "Select p From Person P Where p.salary > ?1  AND p.salary < ?2 ORDER BY p.salary DESC, p.lastName ASC";
		// Query query = em.createQuery(queryString);
		// query.setParameter(1, base);
		// query.setParameter(2, ceil);

		String queryString = "Select * From PersonQuery Where salary > :base  AND salary < :ceil ORDER BY salary DESC, lname ASC";
		Query query = em.createNativeQuery(queryString, Person.class);
		query.setParameter("base", base);
		query.setParameter("ceil", ceil);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);
	}

	public void getEmployeesWithSalaryGroupBy(long base) {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select salary, COUNT(salary) From PersonQuery Group By salary Having salary > 4000 AND salary < 5000";
		Query query = em.createNativeQuery(queryString);
		List<Object> objectList = query.getResultList();
		displayObjectResults(queryString, objectList);
	}

	private void getEmployeeFirstameLastnameAndSalaryOnly() {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createNamedQuery("Person.getFNameLNameSalary");
		List<Object> objectList = query.getResultList();
		displayObjectResults("Person.getFNameLNameSalary", objectList);
	}

	public void getMinSalary() {
		System.out.println("\nGet min salary.");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createNamedQuery("Person.getMinSalary");
		Long minSalary = (Long) query.getSingleResult();
		em.close();
		System.out.printf("%,10d", minSalary);
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
