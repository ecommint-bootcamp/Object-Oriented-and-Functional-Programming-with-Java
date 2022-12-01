package org.javaturk.jpa.ch04.id.sequence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import static javax.persistence.FetchType.LAZY;

@Entity(name = "Person")
@Table(name="PersonIdentitySequence")
public class Person {

	@Id //Uses a sequence on Oracle XE for ids
	//
	/*
	 * allocationSize must be greater than 1 otherwise it does not work.
	 * allocationSize is supposed to be the increment by of CREATE SEQUENCE statement but it does not
	 * seem to work with Hibernate on Oracle.
	 * See http://royontechnology.blogspot.com/2010/04/note-on-allocationsize-parameter-of.html
	 * Another issue for Oracle sequences, when tx rolls back values fetched from sequence are not put back.
	 * This causes holes in pk values.
	 */
	@SequenceGenerator(name="PersonIDSequence", sequenceName="MYSEQUENCE1")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PersonIDSequence")
	private int id;
	private String firstName;
	private String lastName;

	public Person() {
	}

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
