package org.javaturk.jpa.ch04.mappings.temporal;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("temporal");
	}

	public static void main(String[] args) {
		Test test = new Test();

		test.createEmployees();
//		test.retrieveAllEmployees();
	}

	void createEmployees() {
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();

		Employee emp1 = new Employee(1);
        emp1.setName("Metin Ozturk");
        emp1.setSalary(5000L);
        emp1.setDateOfBirth(new Date());
        emp1.setCurrentTime(new Date());
        emp1.setDateOfHiring(Calendar.getInstance());
        em.persist(emp1);
        
        Employee emp2 = new Employee(2);
        emp2.setName("Sami Ay");
        emp2.setSalary(2780L);
        emp2.setDateOfBirth(new Date());
        emp2.setCurrentTime(new Date());
        emp2.setDateOfHiring(Calendar.getInstance());
        em.persist(emp2);
		
		tx.commit();
		em.close();
	}
	
	public void retrieveAllEmployees() {
		System.out.println("\nAll of the employees: ");
		EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("SELECT e FROM Employee e");
        Collection<Employee> employees = query.getResultList();
		System.out.println(employees.size() + " objects:");
		for (Employee emp : employees)
			System.out.println(emp);
		em.close();
    }
}
