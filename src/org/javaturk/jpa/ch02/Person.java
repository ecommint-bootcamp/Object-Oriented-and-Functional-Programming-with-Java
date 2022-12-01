package org.javaturk.jpa.ch02;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name = "PERSON_ENTITY")
@NamedQueries({
	@NamedQuery(name="Person.findByLastname", query="Select p from PERSON_ENTITY p where p.lastName=:lname"),
	@NamedQuery(name="Person.findByLastname2", query="Select p from PERSON_ENTITY p where p.lastName=:lname")})
public class Person {

	@Id
	private int id;
	private String firstName;
	private String lastName;

	public Person() {}

	public Person(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", id=" + id + ", lastName="
				+ lastName + "]";
	}
	
	@Override
	public boolean equals(Object o){
		boolean b = false;
		Person p = (Person) o;
		if(id == p.getId())
			b = true;
		return b;
	}
	
	@Override
	public int hashCode(){
		return id;
	}
}

