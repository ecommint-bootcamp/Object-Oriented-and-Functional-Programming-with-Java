package org.javaturk.jpa.ch04.id.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name="Student")
@Table(name="StudentIdentityTable")
public class Student {

	@Id
	@TableGenerator(
            name="StudentIDGenerator", 
            table="IDGeneratorTable", 
            pkColumnName="IDGenerator", 
            valueColumnName="IDValue", 
            pkColumnValue="StudentID",
            initialValue=250,
            allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="StudentIDGenerator")
	private long id;
	private String firstName;
	private String lastName;
	
	public Student() {
		
	}

	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
		return "Student [Id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
}
