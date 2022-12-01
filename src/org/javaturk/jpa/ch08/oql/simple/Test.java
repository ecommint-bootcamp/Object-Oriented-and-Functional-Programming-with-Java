package org.javaturk.jpa.ch08.oql.simple;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("oqlSimple");
	}

	public static void main(String[] args) {
		Test test = new Test();
//		 test.createPersons(100);
//		 test.getPersonsWithLastname("Aslan");
//		 test.getPersonsWithFirstnameAndLastname("Ahmet", "Aslan");
//		 test.getPersonsWithFirstnameOrLastname("Ahmet", "Aslan");
//		 test.getPersonsWithLastnameLike("Ay%");
//		 test.getPersonsWithLastnameIn();
//		 test.getPersonsWithLastnameNotIn();
//		 test.getPersonsWithLastnameNotInWithRange(10, 20);
//		 test.getPersonsWithSalaryOrderByFirstnameAndLastnameOrderBy(1000, 2000);
//		 test.getPersonsWithSalaryOrderByFirstnameAndLastnameOrderByParametric(1000, 2000);
//		 test.getCountOfSalariesGroupBy(1000, 2000);
//		 test.getPersonFirstNameAndLastnameAndSalaryOnly();
//		 test.getPersonObjectWithDiffFields();
//		test.getTotalSalary();
		test.getAverageSalary();
//		 test.getMaxSalary();
//		 test.getMinSalary();
//		
//		test.getPersonsWithMoreSalaryThanAverage();
		test.getPersonsWithMinSalary();
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

	public void getPersonsWithLastname(String lastname) {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select p From Person p Where p.lastName=\'" + lastname + "\'";
		Query query = em.createQuery(queryString);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);
	}

	public void getPersonsWithFirstnameAndLastname(String firstname, String lastname) {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select p From Person p Where p.firstName=\'" + firstname + "\' AND p.lastName=\'"
				+ lastname + "\'";
		Query query = em.createQuery(queryString);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);
	}

	public void getPersonsWithFirstnameOrLastname(String firstname, String lastname) {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select p From Person P Where p.firstName=\'" + firstname + "\' OR p.lastName=\'"
				+ lastname + "\'";
		Query query = em.createQuery(queryString);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);
	}

	public void getPersonsWithLastnameLike(String lastname) {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select p From Person p Where p.lastName LIKE \'" + lastname + "\'";
		Query query = em.createQuery(queryString);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);
	}

	public void getPersonsWithLastnameIn() {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select p From Person p Where p.lastName IN ('Esen', 'Aslan')";
		Query query = em.createQuery(queryString);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);
	}

	public void getPersonsWithLastnameNotIn() {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select p From Person p Where p.lastName NOT IN ('Aslan', 'Arabaci', 'Aymaz', 'Ayna')";
		Query query = em.createQuery(queryString);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);
	}

	public void getPersonsWithLastnameNotInWithRange(int start, int count) {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select p From Person p Where p.lastName NOT IN ('Aslan', 'Arabaci', 'Aymaz', 'Ayna')";
		Query query = em.createQuery(queryString);
		query.setFirstResult(start);
		query.setMaxResults(count);
		List<Person> personList = query.getResultList();
		// Person p= (Person) query.getSingleResult();
		// System.out.println(p);
		displayResults(queryString, personList);
	}

	public void getPersonsWithSalaryOrderByFirstnameAndLastnameOrderBy(long base, long ceil) {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select p From Person p Where p.salary > " + base + " AND p.salary < " + ceil
				+ " ORDER BY p.salary DESC , p.lastName DESC";
		Query query = em.createQuery(queryString);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);
	}

	public void getPersonsWithSalaryOrderByFirstnameAndLastnameOrderByParametric(long base, long ceil) {
		EntityManager em = PersistenceUtil.getEntityManager();
		// String queryString =
		// "Select p From Person P Where p.salary > ?1  AND p.salary < ?2 ORDER BY p.salary DESC, p.lastName ASC";
		// Query query = em.createQuery(queryString);
		// query.setParameter(1, base);
		// query.setParameter(2, ceil);

		String queryString = "Select p From Person p Where p.salary > :base  AND p.salary < :ceil ORDER BY p.salary DESC, p.lastName ASC";
		Query query = em.createQuery(queryString);
		query.setParameter("base", base);
		query.setParameter("ceil", ceil);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);
	}

	public void getCountOfSalariesGroupBy(long base, long ceil) {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select p.salary, COUNT(p) From Person p Group By p.salary Having p.salary > " + base + " AND p.salary < " + ceil;
		Query query = em.createQuery(queryString);
		List<Object> objectList = query.getResultList();
		displayObjectResults(queryString, objectList);
	}

	private void getPersonFirstNameAndLastnameAndSalaryOnly() {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select p.firstName, p.lastName, p.salary From Person p";
		Query query = em.createQuery(queryString);
		List<Object> objectList = query.getResultList();
		displayObjectResults(queryString, objectList);
	}
	
	public void getTotalSalary() {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select SUM(p.salary) From Person p";
		Query query = em.createQuery(queryString);
		long sumOfSalary  = (long) query.getSingleResult();
		System.out.println(queryString);
		System.out.printf("%,10d", sumOfSalary);
	}
	
	public void getAverageSalary() {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select AVG(p.salary) From Person p";
		Query query = em.createQuery(queryString);
		double sumOfSalary  = (double) query.getSingleResult();
		System.out.printf("%,10f", sumOfSalary);
	}
	
	public void getMaxSalary() {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select MAX(p.salary) From Person p";
		Query query = em.createQuery(queryString);
		long maxSalary  = (long) query.getSingleResult();
		System.out.printf("%,10d", maxSalary);
	}
	
	public void getMinSalary() {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select MIn(p.salary) From Person p";
		Query query = em.createQuery(queryString);
		long minSalary  = (long) query.getSingleResult();
		System.out.printf("%,10d", minSalary);
	}
	
	private void getPersonsWithMoreSalaryThanAverage() {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select p From Person p Where p.salary > (SELECT AVG(p1.salary) FROM Person p1)";
		Query query = em.createQuery(queryString);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);	
	}
	
	private void getPersonsWithMinSalary() {
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select p From Person p Where p.salary = (SELECT MIN(p1.salary) FROM Person p1)";
		Query query = em.createQuery(queryString);
		List<Person> personList = query.getResultList();
		displayResults(queryString, personList);	
	}
	
	public void getPersonObjectWithDiffFields(){
		EntityManager em = PersistenceUtil.getEntityManager();
		String queryString = "Select p FROM Person p WHERE p.id = :x1";
		TypedQuery<Person> query = em.createQuery(queryString, Person.class);
		query.setParameter("x1", 1572439475);
		Person person =  query.getSingleResult();
		System.out.println(queryString);
		System.out.println(person);
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
