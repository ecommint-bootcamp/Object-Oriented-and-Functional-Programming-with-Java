package org.javaturk.jpa.ch13.plain.tx.annotation;

public interface PersonDaoI {
	
	void createPersonWithCar(boolean problem);

	public void deletePersonWithCar();

	public void retrieveAllPersons();
}
