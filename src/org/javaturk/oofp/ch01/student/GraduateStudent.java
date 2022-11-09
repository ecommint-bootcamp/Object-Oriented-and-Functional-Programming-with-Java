package org.javaturk.oofp.ch01.student;

import java.util.Date;

public class GraduateStudent extends Student{
	protected String advisor;
	protected String thesis;

	public GraduateStudent(int no, String name, int year, Date dob, String major, String advisor, String thesis) {
		super(no, name, year, dob, major);
		this.advisor = advisor;
		this.thesis = thesis;
	}

	@Override
	public void study() {
		System.out.println("Graduate Student is studying");
	}

	@Override
	public void register() {
		System.out.println("Graduate Student is registered");
	}
	
	public void writeThesis() {
		System.out.println("Graduate Student is writing a thesis");
	}

	public void meetWithAdvisor() {
		System.out.println("Graduate Student meets with advisor");
	}

	public String getAdvisor() {
		return advisor;
	}

	public void setAdvisor(String advisor) {
		this.advisor = advisor;
	}

	public String getThesis() {
		return thesis;
	}

	public void setThesis(String thesis) {
		this.thesis = thesis;
	}
	
	
	
	
}
