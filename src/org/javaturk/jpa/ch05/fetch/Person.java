package org.javaturk.jpa.ch05.fetch;

import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity(name = "Person")
@Table(name="PersonBasicFetch",
	   uniqueConstraints=@UniqueConstraint(
	   columnNames={"PERSONID","FNAME", "LNAME", "RATE"}))

//@Table(name="PersonBasicColumn")
public class Person {

	@Id //signifies the primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PERSONID")
	private int id;
	
	@Column(name="FNAME", length=20, nullable=false, insertable=true, updatable=false)
	@Basic(fetch=FetchType.LAZY)
	private String firstName;
	
	@Column(name="LNAME", length=40, nullable=false, insertable=true, updatable=false)
	@Basic(fetch=FetchType.LAZY)
	private String lastName;
	
	@Column(name="RATE", nullable=false, scale=2, precision=4, insertable=true, updatable=true)
	@Basic(fetch=FetchType.LAZY)
	private BigDecimal rate;	
	
	@Column(name="SALARY", nullable=false, scale=2, precision=8, insertable=true, updatable=true)
	@Basic(fetch=FetchType.LAZY)
	private BigDecimal salary;

	@Column(name="CAR", nullable=false, insertable=true, updatable=true)
	@Basic(fetch=FetchType.LAZY)
	private Car car;
	
	
	public Person() {
	}

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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", rate=" + rate + ", salary=" + salary + ", car="
				+ car + "]";
	}	
}
