package org.javaturk.oofp.ch01.student;

import java.util.Date;

public class PhdStudent extends GraduateStudent {
    private boolean qualifyingExamTaken;

    public PhdStudent(int no, String name, int year, Date dob, String major, String advisor, String thesis,
                      boolean qualifyingExamTaken) {
        super(no, name, year, dob, major, advisor, thesis);
        this.qualifyingExamTaken = qualifyingExamTaken;
    }

    @Override
    public void study() {
        System.out.println("Phd Student " + getName() + " studying...");
    }

    @Override
    public void register() {
        System.out.println("Phd Student " + getName() + " registered.");
    }

    @Override
    public void writeThesis() {
        System.out.println("Phd Student " + getName() + " writing thesis about " + getThesis());
    }

    @Override
    public void meetWithAdvisor() {
        System.out.println("Phd Student " + getName() + " meet with " + getAdvisor());
    }

    public void writePaper() {
        System.out.println("Phd Student " + getName() + " writing paper...");
    }
}
