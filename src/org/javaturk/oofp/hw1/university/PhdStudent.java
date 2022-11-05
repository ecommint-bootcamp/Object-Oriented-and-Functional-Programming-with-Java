package org.javaturk.oofp.hw1.university;

import java.util.Date;

public class PhdStudent extends GraduateStudent{
    private boolean qualifyingExamTaken;

    public PhdStudent(int no, String name, int year, Date dob, String major, String advisor, String thesis, boolean qualifyingExamTaken) {
        super(no, name, year, dob, major, advisor, thesis);
        this.qualifyingExamTaken = qualifyingExamTaken;
    }

    @Override
    public void study() {
        System.out.println("Phd Student starting to study.");

    }

    @Override
    public void register() {
        System.out.println("Phd Student registered the university.");

    }

    @Override
    public void writeThesis() {
        System.out.println("Phd student starting to write thesis.");

    }

    @Override
    public void meetWithAdvisor() {
        System.out.println("Phd student meeting with Advisor.");

    }


    public void writePaper() {
        System.out.println("Phd student starting to write paper.");

    }
}
