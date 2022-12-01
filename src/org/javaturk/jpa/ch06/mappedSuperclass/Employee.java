package org.javaturk.jpa.ch06.mappedSuperclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="EMPLOYEE_MAPPEDSUPERCLASS")
@DiscriminatorColumn(name="TYPE")
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
