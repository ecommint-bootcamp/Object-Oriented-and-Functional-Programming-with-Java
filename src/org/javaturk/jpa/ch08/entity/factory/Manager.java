package org.javaturk.jpa.ch08.entity.factory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Manager")
@Table(name="QManager")
public class Manager extends Employee{
	
	private static final int MANAGEMENT_PAYMENT = 1500;

	@Column(name="MANAGINGDEPARTMENT")
	protected String managingDepartment;
	
	@OneToOne(mappedBy="pm")
	protected Project projectManaged;
	
	public Manager(){}
	
	public Manager(String firstName, String lastName, String department, String managingDepartment, int year) {
		super(firstName, lastName, department, year);
		this.managingDepartment = managingDepartment;
	}
	
	public int calculateSalary(){
		return MANAGEMENT_PAYMENT + super.calculateSalary();
	}
	
	public String getManagingDepartment() {
		return managingDepartment;
	}

	public void setManagingDepartment(String managingDepartment) {
		this.managingDepartment = managingDepartment;
	}

	public Project getProjectManaged() {
		return projectManaged;
	}

	public void setProjectManaged(Project projectManaged) {
		this.projectManaged = projectManaged;
		projectManaged.setPm(this);
	}

	/**
	 * @author akin
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Manager [managingDepartment=" + managingDepartment + ", department=" + department + ", year="
				+ year + ", id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", car=" + car + "]";
	}
}
