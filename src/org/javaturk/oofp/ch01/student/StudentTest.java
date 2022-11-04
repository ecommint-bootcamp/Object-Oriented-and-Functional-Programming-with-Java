package org.javaturk.oofp.ch01.student;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentTest {
    public static void main(String[] args) {

        RegistrationOffice registrationOffice = new RegistrationOffice();

        Student s0 = new Student(1,"ahmet", 2001, new Date(), "math");
        Student s1 = new GraduateStudent(2, "mehmet", 2002, new Date(), "electrical engineer", "ahmet", "cyber");
        Student s2 = new UndergraduateStudent(3, "ayse", 2003, new Date(), "computer", "industry");
        Student s3 = new VocationalStudent(4, "fatma", 2004, new Date(), "mechanical");
        Student s4 = new MasterStudent(5, "hayriye", 2005, new Date(), "english", "Prof. Ali", "a subject");

        System.out.println(s0.toString());
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());

        s1.study();
        registrationOffice.registerStudent(s0);
        registrationOffice.registerStudent(s4);

    }
}
