package org.javaturk.oofp.ch01.student;

import java.util.Date;

public class VocationalStudent extends Student {
    public VocationalStudent(int no, String name, int year, Date dob, String major) {
        super(no, name, year, dob, major);
    }

    @Override
    public void study() {
        System.out.println("Vocational Student studying...");
    }

    public void register() {
        System.out.println("Vocational Student " + getName() + " registered.");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
