package org.javaturk.jpa.ch04.mappings.lob.person;

import javax.persistence.Access;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.*;

@Entity(name = "Person")
@Table(name = "PersonLob")
@Access(value=AccessType.PROPERTY)
public class Person {

	
	private int id;
	private String firstName;
	private String lastName;
	
	@Lob
	byte[] picture = new byte[1_000_000_000];
	
	
//	char[] cv = new char[10000];  // This does not work on Derby. 
//	Change its type to String, it works.
	@Lob
	String cv;

	public Person() {
	}

	public Person(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic(fetch = FetchType.EAGER)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Basic(fetch = FetchType.EAGER)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Lob
	@Column(name = "Picture")
	@Basic(fetch = FetchType.EAGER)
	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Lob
	@Column(name = "CV")
	@Basic(fetch = FetchType.EAGER)
	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String toString() {
		return "Person [firstName=" + firstName + ", id=" + id + ", lastName="
				+ lastName + "]";
	}

	@Override
	public boolean equals(Object o) {
		boolean b = false;
		Person p = (Person) o;
		if (id == p.getId())
			b = true;
		return b;
	}

	@Override
	public int hashCode() {
		return id;
	}
}
