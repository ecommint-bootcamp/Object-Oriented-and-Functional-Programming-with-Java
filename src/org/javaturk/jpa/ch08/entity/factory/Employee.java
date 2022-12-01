package org.javaturk.jpa.ch08.entity.factory;

import java.util.*;

import javax.persistence.*;

@Entity(name="Employee")
@Table(name="QEmployee")
public class Employee extends Person{
	
	private static final int BASE_SALARY = 300;
	
	@Column(name="DEPARTMENT")
	protected  String department;
	
	@Column(name="EMPLOYMENTYEAR")
	protected int year;
	
	@ManyToMany
	@JoinTable(name = "EMPLOYEE_PROJECT", 
	joinColumns = @JoinColumn(name = "EMPLOYEEID"), 
	inverseJoinColumns = @JoinColumn(name = "PROJECTID"))
	protected Set<Project> projects;
	
	@OneToMany(mappedBy="responsible", cascade=CascadeType.PERSIST)
	protected Set<Task> tasks;
	
	public Employee(){
		projects = new HashSet<>();
		tasks = new HashSet<>();
	}
	
	public Employee(String firstName, String lastName, String department, int year) {
		super(firstName, lastName);
		this.department = department;
		this.year = year;
		projects = new HashSet<>();
		tasks = new HashSet<>();
	}
	
	public int calculateSalary(){
		return year * BASE_SALARY;
	}
	
	public boolean include(Project p){
		return projects.add(p);
	}
	
	public boolean exclude(Project p){
		return projects.remove(p);
	}
	
	public boolean assign(Task t){
		t.setResponsible(this);
		return tasks.add(t);
	}
	
	public boolean unAssign(Task t){
		return tasks.remove(t);
	}

	@Override
	public String toString() {
		return "Employee [department=" + department + ", year=" + year + "]";
	}
}
