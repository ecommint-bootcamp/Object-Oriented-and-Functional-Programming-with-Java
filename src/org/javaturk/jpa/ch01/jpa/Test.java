package org.javaturk.jpa.ch01.jpa;

import java.util.Date;
import java.util.List;

import org.javaturk.jpa.ch01.domain.Person;

public class Test {
	public static void main(String[] args) {
		PersonJpaDAO dao = new PersonJpaDAO();

//		 Person person2 = new Person(1111, "Ali", "Ozmen", new Date());
//		 dao.savePerson(person2);

//		int id = 100;
//		Person personRetrieved = dao.retrievePerson(id);
//		if (personRetrieved == null)
//			System.out.println("Person does not exists!");
//		else
//			System.out.println(personRetrieved);
		
		List<Person> persons = dao.retrieveAllPersons();
		for(Person person : persons)
			System.out.println(person);
			
//			dao.deletePerson(person);
		
//		Person person = dao.retrievePerson(366806415);
//		System.out.println(person);
//		System.out.println("Before update: " + person);
//		person.setDob(new Date(100000000));
//		dao.updatePersonDOB(person);
		
//		dao.deletePerson(person);
//		dao.deleteAllPersons();
	}
}
