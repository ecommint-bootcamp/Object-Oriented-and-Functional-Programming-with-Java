package org.javaturk.jpa.ch04.access.mixedAccess;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "Person")
@Table(name="PERSON_MIXED")
@Access(value=AccessType.PROPERTY) // In order to have a mixed access, this @Access line must be here.
public class Person {

//	Field access
	@Id
	@Access(AccessType.FIELD)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PERSONID")
	private int id;
	
//	For property access make these transient
	@Transient
	private String firstPartOfName;
	
	@Transient
	private String lastPartOfName;

	public Person() {
	}

	public Person(String firstName, String lastName) {
		firstPartOfName = firstName;
		firstPartOfName = lastName;
	}

	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="FNAME")
//	If you don't override access type JPA does'nt use properties
	@Access(value=AccessType.PROPERTY)
	public String getFirstName() {
		System.out.println("in getFirstName()");
		return firstPartOfName;
	}

	public void setFirstName(String firstName) {
		firstPartOfName = firstName;
	}

	@Column(name="LNAME")
	@Access(value=AccessType.PROPERTY)
	public String getLastName() {
		System.out.println("in getLastName()");
		return lastPartOfName;
	}

	public void setLastName(String lastName) {
		lastPartOfName = lastName;
	}
	
	@Access(value=AccessType.PROPERTY)
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
