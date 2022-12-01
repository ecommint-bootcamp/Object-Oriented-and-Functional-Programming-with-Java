package org.javaturk.jpa.ch01.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.ch01.contract.PersonDAOI;
import org.javaturk.jpa.ch01.domain.Person;
//import org.javaturk.jpa.ch01.util.PersistenceUtil;
import org.javaturk.jpa.util.PersistenceUtil;

public class PersonJpaDAO implements PersonDAOI {

	public PersonJpaDAO() {
		PersistenceUtil.setPersistenceUnitName("ch01");
	}

	@Override
	public void savePerson(Person person) {
		System.out.println("Saving person:" + person + "\n");
		EntityManager em = PersistenceUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(person);
		tx.commit();
		em.close();
		
		System.out.println("Person saved!");
	}

	@Override
	public Person retrievePerson(int id) {
		System.out.println("Retrieving the person with id = " + id);
		EntityManager em = PersistenceUtil.getEntityManager();

		Person personRetrieved = em.find(Person.class, id);
		em.close();
		if (personRetrieved == null) {
			System.out.println("No such person with id = " + id);
			return null;
		} else {
			return personRetrieved;
		}
	}

	@Override
	public List<Person> retrieveAllPersons() {
		System.out.println("\nRetrieving all persons by query.");
		EntityManager em = PersistenceUtil.getEntityManager();
		Query allPersons = em.createQuery("Select p from Person p");
		List<Person> persons = allPersons.getResultList();
		System.out.println(persons.size() + " objects:");
		em.close();
		return persons;
	}

	@Override
	public void updatePersonDOB(Person person) {
		System.out.println("Updating a person's date of birth:" + person);
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person updatedPerson = em.merge(person);
		if(updatedPerson == null){
			System.out.println("No such person with id = " + person.getId());
			System.out.println("No person updated!");
		}
		else
			System.out.println("Person updated!");
		tx.commit();
		em.close();

	}

	@Override
	public void deletePerson(Person person) {
		System.out.println("Deleting a person:" + person);
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Person personToDelete = em.find(Person.class, person.getId());
		if(personToDelete == null){
			System.out.println("No such person with id = " + person.getId());
			System.out.println("No person deleted!");
		}
		else{
			em.remove(personToDelete);
			System.out.println("Person deleted!");
		}
		tx.commit();
		em.close();
	}

	@Override
	public void deleteAllPersons() {
		System.out.println("Deleting all persons.");
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query allPersons = em.createQuery("Select p from Person p");
		List<Person> persons = allPersons.getResultList();
		for(Person person:persons)
			em.remove(person);
		System.out.println(persons.size() + " persons deleted!");
		tx.commit();
		em.close();
	}
}
