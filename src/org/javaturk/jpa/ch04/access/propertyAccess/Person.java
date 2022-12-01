package org.javaturk.jpa.ch04.access.propertyAccess;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Person")
@Table(name="PERSON_PROPERTY")
@Access(value=AccessType.PROPERTY)
public class Person {
	
	private int id;
	private String firstPartOfName;
	private String lastPartOfName;

	public Person() { }

	public Person(String firstName, String lastName) {
		firstPartOfName = firstName;
		firstPartOfName = lastName;
	}

		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PERSONID")
	public int getId() {
		System.out.println("in getId");
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="FNAME")
	public String getFirstName() {
		System.out.println("in getFirstName");
		return firstPartOfName;
	}

	public void setFirstName(String firstName) {
		System.out.println("in setFirstName");
		firstPartOfName = firstName;
	}

	@Column(name="LNAME")
	public String getLastName() {
		System.out.println("in getLastName");
		return lastPartOfName;
	}

	public void setLastName(String lastName) {
		System.out.println("in setLastName");
		lastPartOfName = lastName;
	}
	
	public int getAge(){
		return 35;	
	}
	
	public void setAge(int age){
		System.out.println("Setting age. Age is " + age);
	}

	public String toString() {
		return "Person [firstName=" + firstPartOfName + ", id=" + id + ", lastName="
				+ lastPartOfName + ", age=" + getAge() + "]";
	}
}
