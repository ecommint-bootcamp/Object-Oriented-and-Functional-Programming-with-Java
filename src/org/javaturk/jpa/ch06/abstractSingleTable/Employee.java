package org.javaturk.jpa.ch06.abstractSingleTable;

import javax.persistence.*;

@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends Person{
	
	private static final int BASE_SALARY = 300;
	
	protected  String department;

	@Column(name="EMPLOYMENTYEAR")
	protected int year;
	
	public Employee(){}
	
	public Employee(String firstName, String lastName, String department, int year) {
		super(firstName, lastName);
		this.department = department;
		this.year = year;
	}
	
	public int calculateSalary(){
		return year * BASE_SALARY;
	}

	public String toString() {
		return "Employee [department=" + department + ", year=" + year
				+ ", id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
}
