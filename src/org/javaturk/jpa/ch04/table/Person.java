package org.javaturk.jpa.ch04.table;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity(name = "Person")
//@Table(name="PersonTable",
//	   uniqueConstraints=@UniqueConstraint(
//	   columnNames={"PERSONID","FNAME", "LNAME"}))

@Table(name="PersonTable")
public class Person {

	@Id 
	@Column(name="PERSONID", updatable=false)
	private int id;
	
//	unique=true sometimes causes problem due to duplicated values 
	@Column(name="FNAME", unique=false, length=20, nullable=true, insertable=true, updatable=true)
	private String firstName;
	
	@Column(name="LNAME", unique=false, length=40, nullable=true, insertable=true, updatable=true)
	private String lastName;
	
	@Column(name="RATE", nullable=true, scale=2, precision=6, insertable=true, updatable=true)
	private BigDecimal rate;
	
	@Column(name="SALARY", nullable=true, scale=2, precision=8, insertable=true, updatable=true)
	private BigDecimal salary;

	public Person() {}

	public Person(String firstName, String lastName, BigDecimal rate, BigDecimal salary) {
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

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", rate=" + rate + ", salary=" + salary + "]";
	}	
}
