package org.javaturk.jpa.ch04.multipleTables.manyTables;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity(name = "Person")
@Table(name="PersonManyTables")
//@SecondaryTables({@SecondaryTable(name="PersonManyTablesAddress"),
//				  @SecondaryTable(name="PersonManyTablesDetail")})
@SecondaryTable(name="PersonManyTablesAddress", pkJoinColumns=@PrimaryKeyJoinColumn(name="PID"))
@SecondaryTable(name="PersonManyTablesDetail", pkJoinColumns=@PrimaryKeyJoinColumn(name="PERSID"))
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
	
	// This part should map to another table called PersonManyTablesAddress
	@Column(table="PersonManyTablesAddress", name = "STREET", nullable = false)  
	private String street;
	
	@Column(table="PersonManyTablesAddress", name = "APPT", nullable = false)  
	private String appt;
	
	@Column(table="PersonManyTablesAddress", name = "CITY", nullable = false)
	private String city;
	
	@Column(table="PersonManyTablesAddress", name = "ZIPCODE", nullable = false)  
	private String zipCode;
	
	
	@Column(table="PersonManyTablesDetail", name = "PHONE1", nullable = false)  
	private String phone1;
	
	@Column(table="PersonManyTablesDetail", name = "PHONE2", nullable = false)  
	private String phone2;
	
	@Column(table="PersonManyTablesDetail", name = "CELLPHONE", nullable = false)  
	private String cellPhone;
	
	@Column(table="PersonManyTablesDetail", name = "FAX", nullable = true)  
	private String fax;

	public Person() {}

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

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", rate=" + rate + ", salary=" + salary
				+ ", street=" + street + ", appt=" + appt + ", city=" + city
				+ ", zipCode=" + zipCode + ", phone1=" + phone1 + ", phone2="
				+ phone2 + ", cellPhone=" + cellPhone + ", fax=" + fax + "]";
	}	
}
