package org.javaturk.jpa.ch01.jdbc;

import java.util.Date;
import java.util.List;

import org.javaturk.jpa.ch01.domain.Person;

public class Test {
	public static void main(String[] args) {
		PersonJdbcDAO dao = new PersonJdbcDAO();
		
//		Person person2 = new Person(1, "Ali", "Ozmen", new Date());
//		dao.savePerson(person2);
//		
		dao.savePersons(100);
		
//		int id = 2;
//		Person personRetrieved = dao.retrievePerson(id);
//		if(personRetrieved == null)
//			System.out.println("Person does not exists!");
//		else
//			System.out.println(personRetrieved);
		
		List<Person> persons = dao.retrieveAllPersons();
		for(Person person : persons)
			System.out.println(person);
		
//		dao.deletePerson(person);
		
//		Person person = dao.retrievePerson(1);
//		System.out.println("Before update: " + person);
//		person.setDob(new Date(2000000000));
//		dao.updatePersonDOB(person);
//		person = dao.retrievePerson(1);
//		System.out.println("After update: " + person);	
		
//		dao.deleteAllPersons();
	}
}
