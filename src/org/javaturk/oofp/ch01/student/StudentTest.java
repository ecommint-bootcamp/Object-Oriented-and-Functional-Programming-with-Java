package org.javaturk.oofp.ch01.student;

public class StudentTest {

	public static void main(String[] args) {
		RegistrationOffice registrationOffice = new RegistrationOffice();
		
		Student student = new UndergraduateStudent(5, "Selim", 1999, null, "K", "Akif");
		Student student2 = new GraduateStudent(6, "Kerim", 1922, null, null, null, null);
		Student student3 = new Student(10, "Mevlüt", 1985, null, "Computer Science");
		
		registrationOffice.registerStudent(student);
		registrationOffice.registerStudent(student2);
		registrationOffice.registerStudent(student3);
		
		System.out.println(registrationOffice.getAStudent());
		

	}

}
