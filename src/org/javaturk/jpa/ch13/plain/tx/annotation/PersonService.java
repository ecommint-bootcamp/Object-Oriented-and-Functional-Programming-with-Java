
package org.javaturk.jpa.ch13.plain.tx.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Transactional
public class PersonService {
	
	@Autowired
	private PersonDaoI personDao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createPersonWithCar(boolean problem){
		personDao.createPersonWithCar(problem);
	}
	
	public void retrieveAllPersons(){
		personDao.retrieveAllPersons();
	}
	
	public void deletePersonWithCar(){
		personDao.deletePersonWithCar();
	}
}
