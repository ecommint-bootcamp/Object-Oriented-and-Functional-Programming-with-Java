package org.javaturk.oofp.ch01.student;

import java.util.Date;

public class UndergraduateStudent extends Student {
    private String minor;

    public UndergraduateStudent(int no, String name, int year, Date dob, String major, String minor) {
        super(no, name, year, dob, major);
        this.minor = minor;
    }

    @Override
    public void study() {
        System.out.println("Undergraduate Student studying...");
    }

    public void register() {
        System.out.println("Undergraduate Student " + getName() + " registered.");
    }

    @Override
    public String toString() {
        return super.toString() +
                ", minor=" + minor;
    }
}
