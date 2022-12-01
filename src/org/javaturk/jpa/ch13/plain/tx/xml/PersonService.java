
package org.javaturk.jpa.ch13.plain.tx.xml;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;

public class PersonService {
	
//	@Autowired
	private PersonDaoI personDao;
	
	public void createPersonsAndCars(boolean problem){
		personDao.createPersonWithCar(problem);
	}
	
	public void retrieveAllPersons(){
		personDao.retrieveAllPersons();
	}
	
	public void deletePersonWithCar(){
		personDao.deletePersonWithCar();
	}
}
