package org.javaturk.jpa.ch04.multipleTables.twoTables;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity(name = "Person")
@Table(name="PersonTwoTables")
@SecondaryTable(name="PersonTwoTablesAddress", 
				pkJoinColumns={@PrimaryKeyJoinColumn(name="ID")})
//@SecondaryTable(name="PersonTwoTablesAddress")
public class Person {

	@Id //signifies the primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PERSONID")
	private int id;
	
	@Column(name="FNAME", length=20, nullable=false, insertable=true, updatable=false)
	private String firstName;
	
	@Column(name="LNAME", length=40, nullable=false, insertable=true, updatable=false)
	private String lastName;
	
	@Column(name="RATE", nullable=false, scale=2, precision=4, insertable=true, updatable=true)
	private BigDecimal rate;
	
	@Column(name="SALARY", nullable=false, scale=2, precision=8, insertable=true, updatable=true)
	private BigDecimal salary;
	
	// This part should map to another table called PersonTwoTablesAddress
	@Column(table="PersonTwoTablesAddress", name = "STREET",nullable = false)  
	private String street;
	
	@Column(table="PersonTwoTablesAddress", name = "APPT",nullable = false)  
	private String appt;
	
	@Column(table="PersonTwoTablesAddress", name = "CITY",nullable = false)
	private String city;
	
	@Column(table="PersonTwoTablesAddress", name = "ZIPCODE",nullable = false)  
	private String zipCode;

	public Person() {}

	public Person(int id, String firstName, String lastName, BigDecimal rate,
			BigDecimal salary, String street, String appt, String city,
			String zipCode) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.rate = rate;
		this.salary = salary;
		this.street = street;
		this.appt = appt;
		this.city = city;
		this.zipCode = zipCode;
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

	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAppt() {
		return appt;
	}

	public void setAppt(String appt) {
		this.appt = appt;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", rate=" + rate + ", salary=" + salary
				+ ", street=" + street + ", appt=" + appt + ", city=" + city
				+ ", zipCode=" + zipCode + "]";
	}
}
