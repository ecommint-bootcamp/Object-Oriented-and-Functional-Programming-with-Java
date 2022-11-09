package org.javaturk.oofp.ch01.student;

import java.util.Date;

public class PhdStudent extends GraduateStudent{
	private boolean qualifyingExamToken;

	public PhdStudent(int no, String name, int year, Date dob, String major, String advisor, String thesis) {
		super(no, name, year, dob, major, advisor, thesis);
	}

	@Override
	public void study() {
		System.out.println("Phd Student is studying");
	}

	@Override
	public void register() {
		System.out.println("Phd Student is registered");
	}

	@Override
	public void writeThesis() {
		System.out.println("Phd Student is writing a thesis");
	}

	@Override
	public void meetWithAdvisor() {
		System.out.println("Phd Student meets with advisor");
	}
	
	public void writePaper() {
		System.out.println("Phd Student writes on paper.");
	}

	public boolean isQualifyingExamToken() {
		return qualifyingExamToken;
	}

	public void setQualifyingExamToken(boolean qualifyingExamToken) {
		this.qualifyingExamToken = qualifyingExamToken;
	}
	
	
}
