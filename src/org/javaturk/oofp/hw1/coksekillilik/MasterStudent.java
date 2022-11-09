package javaturk.oofp.hw1.coksekillilik;

import java.util.Date;

public class MasterStudent extends GraduateStudent {
    public MasterStudent(Integer no, String name, Integer year, Date dob, String major, String advisor, String thesis) {
        super(no, name, year, dob, major, advisor, thesis);
    }

    @Override
    public void study() {
        System.out.println("Master student also studying.");
    }

    @Override
    public void register() {
        System.out.println("Master student registered.");
    }

    @Override
    public void writeThesis() {
        System.out.println("Master student deliver own thesis.");
    }

    @Override
    public void meetWithAdvisor() {
        System.out.println("Master student meet wtih advisor");
    }
}
