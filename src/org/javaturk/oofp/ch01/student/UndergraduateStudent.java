package org.javaturk.oofp.ch01.student;

import java.util.Date;

public class UndergraduateStudent extends Student {
	protected String minor;

	public UndergraduateStudent(int no, String name, int year, Date dob, String major, String minor) {
		super(no, name, year, dob, major);
		this.minor = minor;
	}

	@Override
	public void study() {
		System.out.println("UnderGraduate Student is studying");
	}

	@Override
	public void register() {
		System.out.println("UnderGraduate Student is registered");
	}
	
	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", year=" + year + ", dob=" + dob + ", major=" + major + 
				", minor=" + minor + "]";
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}
	
	

}
