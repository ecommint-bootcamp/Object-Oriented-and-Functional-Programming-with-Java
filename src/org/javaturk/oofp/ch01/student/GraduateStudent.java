package org.javaturk.oofp.ch01.student;
import java.util.Date;
public class GraduateStudent extends Student{
	private String advisor;
    private String thesis;
    
    public GraduateStudent(int no, String name, int year, Date date, String major, String advisor,String thesis) {
    	super(no, name, year, date, major);
        this.advisor = advisor;
        this.thesis = thesis;
    }
    
    @Override
    public void study() {
        System.out.println("Graduate student");
    }

    @Override
    public void register() {
        System.out.println("Register on graduate school");
    }

    public void writeThesis() {
        System.out.println("Writing thesis for graduate degree");
    }

    public void meetWithAdvisor() {
        System.out.println("Graduate student. Meeting with advisor");
    }

}
