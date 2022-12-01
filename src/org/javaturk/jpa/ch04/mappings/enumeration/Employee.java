package org.javaturk.jpa.ch04.mappings.enumeration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeEnum")
public class Employee {

	@Id
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "SALARY", nullable = false, updatable = false)
	private long salary;

	@Enumerated(EnumType.STRING)
	// @Enumerated
	@Column(name = "EMPTYPE")
	private EmployeeType employeeType;

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

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", employeeType=" + employeeType + "]";
	}
}
