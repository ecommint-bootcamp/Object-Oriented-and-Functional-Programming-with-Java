package org.javaturk.jpa.ch06.joined;

import javax.persistence.*;

@Entity(name = "Person")
@Table(name="PERSON_INHERITANCE_JOINED_TABLE")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	
	@Column(name="FIRSTNAME", length=20, nullable=false, insertable=true, updatable=false)
	protected String firstName;
	
	@Column(name="LASTNAME", length=20, nullable=false, insertable=true, updatable=false)
	protected String lastName;

	public Person() {}

	public Person(String firstName, String lastName) {
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

	public String toString() {
		return "Person [firstName=" + firstName + ", id=" + id + ", lastName="
				+ lastName + "]";
	}
}