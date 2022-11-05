package org.javaturk.oofp.hw1.university;

import java.util.Date;

public class MasterStudent extends GraduateStudent {

    public MasterStudent(int no, String name, int year, Date dob, String major, String advisor, String thesis) {
        super(no, name, year, dob, major, advisor, thesis);
    }

    @Override
    public void study() {
        System.out.println("Master Student starting to study.");

    }

    @Override
    public void register() {
        System.out.println("Master student registered the university.");

    }

    @Override
    public void writeThesis() {
        System.out.println("Master student starting to write thesis.");

    }

    @Override
    public void meetWithAdvisor() {
        System.out.println("Master student meeting with Advisor.");

    }

}
