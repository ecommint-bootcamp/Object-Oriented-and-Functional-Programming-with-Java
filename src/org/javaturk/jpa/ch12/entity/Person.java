package org.javaturk.jpa.ch12.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name = "Person")
@Table(name="PersonValidation")
public class Person {

	@Id 
	@Column(name="PERSONID", updatable=false)
	private int id;
	
	@Column(name="FNAME", length=20, nullable=false, insertable=true, updatable=true)
	@NotNull @Size(max=20)
	private String firstName;
	
	@Column(name="LNAME", length=40, nullable=false, insertable=true, updatable=false)
	@NotNull(message="Lastname can not be null!") @Size(max=40)
	private String lastName;
	
	@Column(name="PASSWORD", unique=true, length=40, nullable=false, insertable=true, updatable=false)
	@NotNull @Size(min=6, max=10) @Pattern(regexp="")
	private String password;
	
	@Column(name="RATE", nullable=true, scale=2, precision=6, insertable=true, updatable=true)
	@DecimalMin(value="19.73") @DecimalMax(value="87.04")
	private BigDecimal rate;
	
	@Column(name="SALARY", nullable=true, scale=2, precision=8, insertable=true, updatable=true)
	@Digits(integer=6, fraction=2)
	private BigDecimal salary;
	
	@Column(name="DOB", nullable=true)
	@Temporal(value = TemporalType.DATE)
	@Past
	private Date dob;
	
	@Column(name="FUTURE", nullable=true)
	@Temporal(value = TemporalType.DATE)
	@Future
	private Date dateInFuture;

	public Person() {}

	public Person(String firstName, String lastName, BigDecimal rate, BigDecimal salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.rate = rate;
		this.salary = salary;
	}

	public Person(int id, String firstName, String lastName, String password, BigDecimal rate, BigDecimal salary,
			Date dob, Date dateInFuture) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.rate = rate;
		this.salary = salary;
		this.dob = dob;
		this.dateInFuture = dateInFuture;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDateInFuture() {
		return dateInFuture;
	}

	public void setDateInFuture(Date dateInFuture) {
		this.dateInFuture = dateInFuture;
	}

	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", rate=" + rate + ", salary=" + salary + "]";
	}
}
