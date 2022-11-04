package org.javaturk.oofp.ch01.student;

import java.util.Date;

public class PhdStudent extends GraduateStudent {
    private boolean qualifyingExamTaken;

    public PhdStudent(String name, int year, Date dob, String major, String advisor, String thesis,boolean qualifyingExamTaken) {
        super(name, year, dob, major, advisor, thesis);
        this.qualifyingExamTaken=qualifyingExamTaken;
    }

    @Override
    public void study() {
        super.study();
    }

    @Override
    public void register() {
        super.register();
    }

    @Override
    public void writeThesis() {
        System.out.println("Graduate student is writing phd thesis " + this.getThesis());
    }

    @Override
    public void meetWithAdvisor() {
        System.out.println("Graduate phd student is meeting with advisor " + this.getAdvisor() );
    }

    public void writePaper(){
        System.out.println("Phd Student is writing a paper...");
    }

    @Override
    public String toString() {
        String s="";
        if(!qualifyingExamTaken){
            s="Student has not taken the qualifying exam.";
        }else{
            s="Student has taken the qualifying exam.";
        }
        return super.toString() + "\n"+s;
    }
}
