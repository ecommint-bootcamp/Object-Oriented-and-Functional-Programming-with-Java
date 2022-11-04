package org.javaturk.oofp.ch01.student;

import java.util.Date;

public class VocationalStudent extends Student {

    public VocationalStudent(String name, int year, Date dob, String major) {
        super(name, year, dob, major);
    }

    public String toString() {
        return super.toString();
    }

    public void register() {
        super.register();
    }

    @Override
    public void study() {
        System.out.println("Vocational student" + this.getName() + "is studying...") ;
    }

}
