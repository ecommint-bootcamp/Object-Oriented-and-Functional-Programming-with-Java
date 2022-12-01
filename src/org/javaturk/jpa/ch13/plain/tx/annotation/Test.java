package org.javaturk.jpa.ch13.plain.tx.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public Test() {}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("org/javaturk/jpa/ch13/plain/tx/annotation/application.xml");
		PersonService service = (PersonService) context.getBean("personService");		
	
		service.createPersonWithCar(false);
		service.retrieveAllPersons();
	}
}