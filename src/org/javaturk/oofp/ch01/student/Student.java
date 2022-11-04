package org.javaturk.oofp.ch01.student;
import java.util.Date;	
public class Student {
	private int no;
    private String name ;
    private int year;
    private Date dob;
    private String major;
    
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
    
    public Student(int no, String name, int year, Date dob, String major) {
        this.no = no;
        this.name = name;
        this.year = year;
        this.dob = dob;
        this.major = major;
    }
    
    public void study() {
        System.out.println("student");
    }
    
    public void register(){
        System.out.println("registered");
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", dob=" + dob +
                ", major='" + major + '\'' +
                '}';
    }
    
}
