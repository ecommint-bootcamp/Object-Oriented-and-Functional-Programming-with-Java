package org.javaturk.oofp.ch01.student;

public class RegistrationOffice {

    public RegistrationOffice() {
    }

    public Student getAStudent() {
        return null;
    }

    public void registerStudent(Student student) {
        if (student instanceof PhdStudent || student instanceof MasterStudent) {
            student.register();
        } else {
            System.out.println(student.getName() + " is not Phd or Master student.");
        }

    }
}
