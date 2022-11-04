package org.javaturk.oofp.ch01.student;
import java.util.Date;
public class PhdStudent extends GraduateStudent {
	private boolean qualilfyingExamTaken;

    public PhdStudent(int no, String name, int year, Date dob, String major, String advisor, String thesis, boolean qualilfyingExamTaken) {
        super(no, name, year, dob, major, advisor, thesis);
        this.qualilfyingExamTaken = qualilfyingExamTaken;
    }
    
    @Override
    public void study() {
        System.out.println("Phd student");
    }

    @Override
    public void register() {
        System.out.println("Register on phd school");
    }

    @Override
    public void writeThesis() {
        System.out.println("Writing thesis for phd degree");
    }

    @Override
    public void meetWithAdvisor() {
        System.out.println("Phd student.Meeting with advisor");

    }

    public void writePaper() {
        System.out.println("Writing paper for phd degree");
    }

}
