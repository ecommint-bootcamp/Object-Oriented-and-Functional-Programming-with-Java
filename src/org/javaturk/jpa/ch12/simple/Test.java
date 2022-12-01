package org.javaturk.jpa.ch12.simple;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.validation.Path;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.metadata.ConstraintDescriptor;

import org.javaturk.jpa.ch12.entity.Factory;
import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
//		PersistenceUtil.setPersistenceUnitName("validation");
	}

	public static void main(String[] args) {
		Test test = new Test();

		test.validatePerson();
//		test.createPerson();
		// test.createPersons(5);
		// test.retrieveAPerson(1);
		// test.retrieveAllPersons();

	}

	public void validatePerson() {
		Person p = new Person();
		p.setId(5);
//		p.setFirstName(null);
//		p.setLastName(null);
//		p.setPassword("qwe123");
		p.setRate(new BigDecimal("7.91"));
		p.setSalary(new BigDecimal("340877.77"));
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Person>> violations = validator.validate(p);
		System.out.println("Number of violations: " + violations.size());
		Iterator<ConstraintViolation<Person>> i = violations.iterator();
		while(i.hasNext()){
			ConstraintViolation<Person> violation =  i.next();
			System.out.println("\nInvalid object: " + violation.getRootBean());
			Path path = violation.getPropertyPath();
			System.out.println("Invalid field: " + path.toString());
			System.out.println("Violation: \"" + violation.getMessage() + "\"");
			System.out.println("Invalid value: " + violation.getInvalidValue());
			System.out.println(violation.getLeafBean());
			ConstraintDescriptor cd = violation.getConstraintDescriptor();
			System.out.println(cd.getAnnotation());
			Map attributes = cd.getAttributes();
			Set keys = attributes.keySet();
			Iterator ii = keys.iterator();
			while(ii.hasNext()){
				Object key = ii.next();
//				System.out.println(key.getClass().getName());
//				System.out.println((attributes.get(key)).getClass().getName());
			}
		}
	}

	void createPerson() {
		System.out.println("Creating a person.");
		EntityManager em = PersistenceUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person p = new Person();
		p.setId(5);
		p.setFirstName(null);
		p.setLastName(null);
		p.setPassword("qwe123");
		// If you give double as argument to BigDecimal, it will give you an
		// error
		// stating that it exceeds 31 digits!
		p.setRate(new BigDecimal("27.91"));
		p.setSalary(new BigDecimal("340877.77"));

		em.persist(p);
		//
		tx.commit();
		em.close();
	}

	void createPersons(int n) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Person p = null;
		for (int i = 0; i < n; i++) {
			p = Factory.createPerson(); // Unique constraints on Table and
										// Column may give you trouble
			em.persist(p);
		}

		tx.commit();
		em.close();
	}

	private void retrieveAPerson(int id) {
		System.out.println("\nRetrieving the person with id: " + id);
		EntityManager em = PersistenceUtil.getEntityManager();

		Person person = em.find(Person.class, id);
		if (person == null)
			System.out.println("No such person!");
		else
			System.out.println("\n" + person);
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
