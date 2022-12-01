package org.javaturk.jpa.ch01.contract;

import java.util.List;

import org.javaturk.jpa.ch01.domain.Person;

public interface PersonDAOI {
	
	public void savePerson(Person person);
	
	public Person retrievePerson(int id);
	
	public List<Person> retrieveAllPersons();
	
	public void updatePersonDOB(Person person);
	
	public void deletePerson(Person person);
	
	public void deleteAllPersons();

}
