package org.javaturk.oofp.ch01.student;

import java.util.Date;

public class GraduateStudent extends Student {
    private String advisor;
    private String thesis;
    public GraduateStudent(int no, String name, int year, Date dob, String major,String advisor, String thesis) {
        super(no, name, year, dob, major);
        this.advisor=advisor;
        this.thesis=thesis;
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

    @Override
    public String toString() {
        return super.toString() + "\n Thesis: " + thesis +
                                    "\n Advisor:" + advisor;

    }

    @Override
    public void study(){
        System.out.println("Graduate student" + this.getName() + "is studying...");
    }

    public void register(){
        super.register();
    }

    public void writeThesis(){
        System.out.println("Graduate student is writing thesis " + thesis );
    }
    public void meetWithAdvisor(){
        System.out.println("Graduate student is meeting with advisor " + advisor );
    }
}
