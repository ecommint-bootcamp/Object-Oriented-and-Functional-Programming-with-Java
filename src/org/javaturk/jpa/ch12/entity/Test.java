package org.javaturk.jpa.ch12.entity;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Test {

	public static void main(String[] args) {
		Test test = new Test();

		test.validatePerson();

	}

	public void validatePerson() {
		System.out.println("Validating a person.");
		Person p = new Person();
		p.setId(5);
		p.setFirstName(null);
		p.setLastName(null);
		p.setPassword("qwe123");
		p.setRate(new BigDecimal("27.91"));
		p.setSalary(new BigDecimal("340877.77"));
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<Person>> constraintViolations = validator.validate(p);
		System.out.println(constraintViolations.size());
		Iterator i = constraintViolations.iterator();
		while(i.hasNext())
			System.out.println(i.next());
	}
}
