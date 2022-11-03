package org.javaturk.oofp.ch01.student;

import java.util.Date;

public class MasterStudent extends GraduateStudent{

    public MasterStudent(int no, String name, int year, Date dob, String major, String advisor, String thesis) {
        super(no, name, year, dob, major, advisor, thesis);
    }

    @Override
    public void study() {
        System.out.println("Graduate master student" + this.getName() + "is studying...");
    }


    public void register() {
        super.register();
    }

    @Override
    public void writeThesis() {
        System.out.println("Graduate student is writing master thesis " + this.getThesis());
    }



    public void meetWithAdvisor() {
        System.out.println("Graduate master student is meeting with advisor " + this.getAdvisor() );
    }
}
