package org.javaturk.oofp.hw1.university;

import java.util.Date;

public class UndergraduateStudent extends Student {
    protected String minor;

    public UndergraduateStudent(int no, String name, int year, Date dob, String major, String minor) {
        super(no, name, year, dob, major);
        this.minor = minor;
    }

    @Override
    public void study() {
        System.out.println("Undergraduate Student starting to study.");
    }

    @Override
    public void register() {
        System.out.println("Undergraduate Student registered the university.");

    }

    @Override
    public String toString() {
        return "UndergraduateStudent{" + "no=" + no + ", name='" + name + '\'' + ", year=" + year +  ", dob=" + dob + ", major='" + major + '\'' +
                "minor=" + minor + '}';
    }
}
