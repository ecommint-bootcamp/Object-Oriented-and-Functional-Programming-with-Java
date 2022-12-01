package org.javaturk.jpa.ch08.oql.simple;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.EntityResult;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity(name = "Person")
@Table(name = "PersonQuery")
@NamedQueries({ @NamedQuery(name = "Person.findById", query = "Select c From Person c Where c.id = :id"),
		@NamedQuery(name = "Person.fetchAllPersons", query = "Select c From Person c"),
		@NamedQuery(name = "Person.findPersonWithSpecifiedName", query = "Select c From Person c Where c.firstName=:firstName AND c.lastName=:lastName"),
		@NamedQuery(name = "Person.getMinSalary", query = "Select MIN(p.salary) From Person p"),
		@NamedQuery(name = "Person.getFNameLNameSalary", query = "Select p.firstName, p.lastName, p.salary From Person p") })
public class Person {

	@Id
	@Column(name = "PERSONID", updatable = false)
	private int id;

//	unique=true sometimes causes problem due to duplicated values 
	@Column(name = "FNAME", length = 20, nullable = false, insertable = true, updatable = true)
	private String firstName;

	@Column(name = "LNAME", length = 40, nullable = false, insertable = true, updatable = false)
	private String lastName;

	@Column(name = "RATE", nullable = true, scale = 2, precision = 6, insertable = true, updatable = true)
	private BigDecimal rate;

	@Column(name = "SALARY", nullable = true, precision = 8, insertable = true, updatable = true)
	private long salary;

	public Person() {
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person(String firstName, String lastName, BigDecimal rate, long salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.rate = rate;
		this.salary = salary;
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

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", rate=" + rate
				+ ", salary=" + salary + "]";
	}
}
