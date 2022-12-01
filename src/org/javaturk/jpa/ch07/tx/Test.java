package org.javaturk.jpa.ch07.tx;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {

	public Test() {
		PersistenceUtil.setPersistenceUnitName("tx");
	}

	public static void main(String[] args) {
//		createTable(); // Creates tables necessary for entities if "javax.persistence.schema-generation.database.action=drop-and-create" is in effect
		
		Test test = new Test();
		test.start();
	}
	
	public void start(){
		String nString = JOptionPane.showInputDialog("Please enter number of persons:");
		int n = Integer.parseInt(nString);
		
		Person[] persons = populate(n);
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < n; i++){
			createPersonWithFlush(persons[i]);
		}
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start) + " ms.");
	}
	
	public Person[] populate(int n){
		System.out.println("Creating " + n + " persons.");
		Person[] persons = new Person[n];
		for(int i = 0; i < n; i++){
			Person person = Factory.createPerson();
			persons[i] = person;
		}
		return persons;
	}
	
	public static void createTable(){
		PersistenceUtil.setPersistenceUnitName("tx");
		EntityManager em = PersistenceUtil.getEntityManager();
		em.close();
	}


	void createPersonWithoutFlush(Person person) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(person);
		tx.commit();
		em.close();
	}

	void createPersonWithFlush(Person person) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(person);
		em.flush();
		tx.commit();
		em.close();
	}
}
