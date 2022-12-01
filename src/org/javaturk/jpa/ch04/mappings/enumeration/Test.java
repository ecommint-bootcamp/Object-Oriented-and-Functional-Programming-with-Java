package org.javaturk.jpa.ch04.mappings.enumeration;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("enumeration");
	}

	public static void main(String[] args) {
		Test test = new Test();

		test.createEmployees();
		test.retrieveAllEmployees();
	}

	void createEmployees() {
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();

		Employee emp1 = new Employee(111);
        emp1.setName("Cem Aslan");
        emp1.setSalary(5200L);
        emp1.setEmployeeType(EmployeeType.ADMIN);
        em.persist(emp1);
        
        Employee emp2 = new Employee(222);
        emp2.setName("MBappe");
        emp2.setSalary(4500L);
        emp2.setEmployeeType(EmployeeType.OFFICER);
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
