package org.javaturk.jpa.ch02.studentJPA.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Students")
public class Student {
	@Id
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private int year;
	
	private Date dob;
	
	private double gpa;

	
	public Student() {}
	
	public Student(int id,String firstName, String lastName, int year, Date dob, double gpa) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.year = year;
		this.dob = dob;
		this.gpa = gpa;
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
	
	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		Student student = (Student) obj;
		if(id == student.getId())
			b = true;
		return b;
	}
	
	@Override
	public int hashCode(){
		return id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", year=" + year + ", dob="
				+ dob + ", gpa=" + gpa + "]";
	}
	
}
