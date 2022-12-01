package org.javaturk.jpa.ch07.tx;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.javaturk.jpa.util.PersistenceUtil;

public class TXActiveTest {
	
	public TXActiveTest() {
		PersistenceUtil.setPersistenceUnitName("tx");
	}

	public static void main(String[] args) {
		TXActiveTest test = new TXActiveTest();
		test.updatePerson(10);

	}
	
	public void updatePerson(int id) {
		System.err.println("\nUpdating a person with id: " + id);
		EntityManager em = PersistenceUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();
		printTX("Just after getting transaction ", tx);
		tx.begin();
		printTX("After calling begin() ", tx);
		
		Person person = em.find(Person.class, id);
//		System.err.println("Person fetched from the db: " + person);

		person.setLastName(person.getLastName() + "X");
//		System.err.println("Updated person: " + person);

		printTX("Before calling commit() ", tx);
		
		tx.commit();
		printTX("After calling commit() ", tx);
		em.close();
	}
	
	private void printTX(String place, EntityTransaction tx) {
		System.err.print(place);
		if(tx.isActive())
			System.err.println(", TX is active!");
		else
			System.err.println(", TX is not active!");
	}
}
