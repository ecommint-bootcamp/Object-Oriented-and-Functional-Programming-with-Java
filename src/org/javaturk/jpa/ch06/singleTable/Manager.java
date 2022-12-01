package org.javaturk.jpa.ch06.singleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MANAGER")
public class Manager extends Employee{
	
	private static final int MANAGEMENT_PAYMENT = 1500;

	protected String managingDepartment;
	
	public Manager(){}
	
	public Manager(String firstName, String lastName, String department, String managingDepartment, int year) {
		super(firstName, lastName, department, year);
		this.managingDepartment = managingDepartment;
	}
	
	public int calculateSalary(){
		return MANAGEMENT_PAYMENT + super.calculateSalary();
	}

	public String toString() {
		return "Manager [managingDepartment=" + managingDepartment + ", department=" + department + ", year=" + year
				+ ", id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
