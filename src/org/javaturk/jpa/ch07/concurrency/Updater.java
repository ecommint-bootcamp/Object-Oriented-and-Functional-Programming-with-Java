
package org.javaturk.jpa.ch07.concurrency;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;

import org.javaturk.jpa.ch07.concurrency.domain.Person;
import org.javaturk.jpa.util.PersistenceUtil;

public class Updater extends Thread {

	private LockModeType mode;
	private int updateId;

	public Updater(String name, LockModeType mode, int updateId) {
		super(name);
		this.mode = mode;
		this.updateId = updateId;
		PersistenceUtil.setPersistenceUnitName("personLocking");
	}

	public void run() {
		System.err.println(getName() + " =>  starts.");

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		System.err.println(getName() + " =>  Chancing the last name of a person by thread.");

		tx.begin();
		Person person = loadPerson(em);
		System.err.println(getName() + " =>  Person retrieved: " + person);
		// Update it
		updatePerson(person);

		int option = JOptionPane.showConfirmDialog(null, getName() + " =>  Person updated but not yet committed, press a button to continue.");

		if (option == JOptionPane.CANCEL_OPTION | option == JOptionPane.NO_OPTION) {
			System.err.println(getName() + " =>  Nothing updated!");
			tx.rollback();
		} else {
			System.err.println(getName() + " =>  Commiting the change by thread.");
			try {
				tx.commit();
			} catch (RollbackException e) {
				Throwable cause = e.getCause();
				if (cause instanceof OptimisticLockException) {
					System.err.println(getName() + " =>  OptimisticLockException: " + e.getMessage());
				}
				// Now decide what to do
				option = JOptionPane.showConfirmDialog(null,
						" =>  Person retrieved had already been modified by another transaction after you retrieve it. Do you want to reload it again?");
				if (option == JOptionPane.CANCEL_OPTION | option == JOptionPane.NO_OPTION) {
					System.err.println(getName() + " =>  Nothing updated!");
					tx.rollback();
				} else {
					// Hibernate needs a new em to continue otherwisze it throws an exception!
					em = PersistenceUtil.getEntityManager();
					// Start a new tx
					tx = em.getTransaction();
					tx.begin();
					Person personRetrieved2ndTime = loadPerson(em);
					System.err.println("Loading the modified object " + getName() + " =>  " + personRetrieved2ndTime);
					updatePerson(personRetrieved2ndTime);
					tx.commit();
				}
			}
		}

		em.close();
	}

	private void updatePerson(Person person) {
		person.setLastName(getName() + "-" + person.getVersion());
	}

	private Person loadPerson(EntityManager em) {
		Person person = em.find(Person.class, updateId, mode);
		return person;
	}
}
