package org.javaturk.jpa.ch04.mappings.temporal;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EmployeeTemporal")
public class Employee {

	@Id
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "SALARY")
	private long salary;

	@Temporal(TemporalType.DATE)
	@Column(name = "DOB")
	private Date dateOfBirth;

	@Temporal(TemporalType.TIME)
	private Date currentTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateOfHiring;

	public Employee() {
	}

	public Employee(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Calendar getDateOfHiring() {
		return dateOfHiring;
	}

	public void setDateOfHiring(Calendar dateOfHiring) {
		this.dateOfHiring = dateOfHiring;
	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", dateOfBirth=" + dateOfBirth + ", currentTime="
				+ currentTime + ", dateOfHiring=" + dateOfHiring + "]";
	}
}