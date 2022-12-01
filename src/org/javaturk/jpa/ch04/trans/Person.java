package org.javaturk.jpa.ch04.trans;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "Person")
@Table(name="PersonTransient")
@Access(value=AccessType.PROPERTY)
public class Person {

	private int id;
	private String firstName;
	private String lastName;
	
	@Transient
	private String fullName;

	public Person() {
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		fullName = firstName + " " + lastName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
		fullName = firstName + lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		fullName = firstName + lastName;
	}
//	
	@Transient
	public String getFullName() {
		return fullName;
	}

	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", fullName=" + firstName + " " + lastName + "]";
	}
}
