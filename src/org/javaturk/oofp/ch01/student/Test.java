package org.javaturk.oofp.ch01.student;
import java.text.ParseException;

public class Test {
    public static void main(String[] args) throws ParseException {
        RegistrationOffice registrationOffice = new RegistrationOffice();
        int n = 12;
        Student[] students = new Student[12];
        for (int i = 0; i < n; i++)
            students[i] = registrationOffice.getAStudent();

        for (Student s : students) {
            System.out.println(s);
            System.out.println("-------------------");
            if(!(s instanceof VocationalStudent)){
                registrationOffice.registerStudent(s);
            }
            if(s instanceof PhdStudent){
                ((PhdStudent) s).writePaper();
            }
        }


    }
}
