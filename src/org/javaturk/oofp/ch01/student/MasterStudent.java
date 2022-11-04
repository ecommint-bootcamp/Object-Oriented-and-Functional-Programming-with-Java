package org.javaturk.oofp.ch01.student;
import java.util.Date;
public class MasterStudent extends GraduateStudent{
	
	public MasterStudent(int no, String name, int year, Date dob, String major, String advisor, String thesis) {
        super(no, name, year, dob, major, advisor, thesis);
    }
	
	 @Override
	    public void study() {
	        System.out.println("Master student");
	    }

	    @Override
	    public void register() {
	        System.out.println("Registered to master");
	    }

	    @Override
	    public void writeThesis() {
	        System.out.println("writing thesis for master degree");
	    }

	    @Override
	    public void meetWithAdvisor() {
	        System.out.println("Master student. Meeting with advisor");
	    }

}
