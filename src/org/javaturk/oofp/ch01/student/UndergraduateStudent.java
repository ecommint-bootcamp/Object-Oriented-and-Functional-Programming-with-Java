package org.javaturk.oofp.ch01.student;

import java.util.Date;

public class UndergraduateStudent extends Student {
    private String minor;
    public UndergraduateStudent(String name, int year, Date dob, String major,String minor) {
        super(name, year, dob, major);
        this.minor=minor;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    @Override
    public String toString() {
        return super.toString() +  "\n Minor: " + minor ;
    }

    @Override
    public void study() {
        System.out.println("Undergraduate student" + this.getName() + "is studying...") ;
    }

    public void register() {
        super.register();
    }


}
