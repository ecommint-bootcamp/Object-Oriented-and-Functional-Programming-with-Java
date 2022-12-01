package org.javaturk.jpa.ch04.id.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "Person")
@Table(name="PersonIdentityTable")
public class Person {

	@Id //Uses a table on Oracle XE for ids
	@TableGenerator(
            name="PersonIDGenerator", 
            table="IDGeneratorTable", 
            pkColumnName="IDGenerator", 
            valueColumnName="IDValue", 
            pkColumnValue="PersonID",
            initialValue=1,
            allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="PersonIDGenerator")
	private int id;
	private String firstName;
	private String lastName;

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
