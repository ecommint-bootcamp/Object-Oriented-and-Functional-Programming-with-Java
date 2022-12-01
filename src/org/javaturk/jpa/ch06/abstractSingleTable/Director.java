package org.javaturk.jpa.ch06.abstractSingleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DIRECTOR")
public class Director extends Manager {

	private static final int ALLOWANCE = 2500;

	public Director(){}
	
	public Director(String firstName, String lastName, String department,
			String managingDepartment, int year) {
		super(firstName, lastName, department, managingDepartment, year);
	}

	public int calculateSalary() {
		return ALLOWANCE + super.calculateSalary();
	}

	public String toString() {
		return "Director [managingDepartment=" + managingDepartment + ", department=" + department + ", year=" + year
				+ ", id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
