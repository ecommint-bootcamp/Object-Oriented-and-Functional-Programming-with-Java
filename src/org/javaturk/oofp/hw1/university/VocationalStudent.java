package org.javaturk.oofp.hw1.university;

import java.util.Date;

public class VocationalStudent extends Student{

    public VocationalStudent(int no, String name, int year, Date dob, String major) {
        super(no, name, year, dob, major);
    }
    @Override
    public void study() {
        System.out.println("Vocational Student starting to study.");
    }

    @Override
    public void register() {
        System.out.println("Vocational Student registered the university.");
    }

    @Override
    public String toString() {
        return "VocationalStudent{" + "no=" + no + ", name='" + name + '\'' + ", year=" + year +  ", dob=" + dob + ", major='" + major + '\'' +
                '}';
    }


}
