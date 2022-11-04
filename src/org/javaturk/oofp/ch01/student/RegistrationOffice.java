package org.javaturk.oofp.ch01.student;
import java.util.Date;
public class RegistrationOffice {
	
	public RegistrationOffice() {
    }

    public Student getAStudent() {
        Student student = null;
        return new Student(10, "Emre", 2020, new Date(), "ComputerEngineer");
    }

    public Student registeredStudent(Student student){
        return student;
    }

}
