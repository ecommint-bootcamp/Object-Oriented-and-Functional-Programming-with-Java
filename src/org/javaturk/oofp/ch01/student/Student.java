package org.javaturk.oofp.ch01.student;


import java.util.Date;

public class Student implements AbstractStudent {
    private int no;
    private String name ;
    private int year;
    private Date dob;
    private String major;


    public Student( int no, String name,int year,Date dob, String major){
         this.no=no;
         this.name=name;
        this.year=year;
        this.dob=dob;
        this.major=major;
    }


    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    
    public String toString(){
        String s="";
        s+= "Student Info:\n " + 
            "Student no:\n " + no +
            "Student name:\n " + name +
            "Year of entry:\n " + year +
            "Date of birth:\n " + dob +
            "Major:\n " + major ;
        return s;
    }

    public void study(){
        System.out.println("Student is working...");
    }
    
    public void register(){
        System.out.println("Student has been registered");
    }




    
}
