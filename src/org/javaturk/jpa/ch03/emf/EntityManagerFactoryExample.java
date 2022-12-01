
package org.javaturk.jpa.ch03.emf;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryExample {

	public static void main(String[] args) {
		createEntityManagerFactoriesUsingProperties();
	}
	
	public static void createEntityManagerFactories(){
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("emf");
		EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("emf");
		
		if(emf1.equals(emf2))
			System.out.println("The same");
		else
			System.out.println("Different");
		
		System.out.println(emf1.isOpen());
		System.out.println(emf2.isOpen());
		
		
		System.out.println(emf1);
		System.out.println(emf2);
		
		EntityManager em1 = emf1.createEntityManager();
		EntityManager em2 = emf2.createEntityManager();
		
		if(em1.equals(em2))
			System.out.println("The same");
		else
			System.out.println("Different");
		
		System.out.println(em1);
		System.out.println(em2);
	}
	
	public static void createEntityManagerFactoriesUsingProperties(){
		Properties properties = new Properties();
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("emf", properties);
		EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("emf", properties);
		
		if(emf1.equals(emf2))
			System.out.println("The same");
		else
			System.out.println("Different");
		
		System.out.println(emf1.isOpen());
		System.out.println(emf2.isOpen());
		
		
		System.out.println(emf1);
		System.out.println(emf2);
		
		EntityManager em1 = emf1.createEntityManager();
		EntityManager em2 = emf2.createEntityManager();
		
		if(em1.equals(em2))
			System.out.println("The same");
		else
			System.out.println("Different");
		
		System.out.println(em1);
		System.out.println(em2);
	}
}
