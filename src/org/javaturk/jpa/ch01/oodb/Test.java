package org.javaturk.jpa.ch01.oodb;

import java.util.Date;
import java.util.List;

import org.javaturk.jpa.ch01.domain.Person;

public class Test {
	public static void main(String[] args) {
		PersonDb4oDAO dao = new PersonDb4oDAO();
//		Person person2 = new Person(2, "Akin", "Kaldiroglu", new Date());
//		dao.savePerson(person2);
		
//		dao.savePersons(100);
		
//		int id = 2;
//		Person personRetrieved = dao.retrievePerson(id);
//		if(personRetrieved == null)
//			System.out.println("Person does not exists!");
//		else
//			System.out.println(personRetrieved);
		
		List<Person> persons = dao.retrieveAllPersons();
		for(Person person : persons)
			System.out.println(person);
//		
//		dao.deletePerson(person);
		
//		Person person = dao.retrievePerson(115236132);
//		System.out.println("Before update: " + person);
//		person.setDob(new Date(200000000));
//		dao.updatePersonDOB(person);
//		person = dao.retrievePerson(115236132);
//		System.out.println("After update: " + person);	
		
//		dao.deleteAllPersons();
		
		dao.closeDB();
	}
}
