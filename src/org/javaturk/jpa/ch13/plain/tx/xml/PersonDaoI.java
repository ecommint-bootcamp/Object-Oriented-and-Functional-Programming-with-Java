package org.javaturk.jpa.ch13.plain.tx.xml;

public interface PersonDaoI {
	
	void createPersonWithCar(boolean problem);

	public void deletePersonWithCar();

	public void retrieveAllPersons();
}
