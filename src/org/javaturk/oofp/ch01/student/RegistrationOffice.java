package org.javaturk.oofp.ch01.student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistrationOffice {
	
	public RegistrationOffice() {}
	
	public Student getAStudent() {
		List<Student> students = createStudents();
		Student student = students.get((int) (Math.random() * 10));
		return student;
	}
	
	public void registerStudent(Student student) {
		if(student instanceof UndergraduateStudent) {
			UndergraduateStudent underGraduateStudent = (UndergraduateStudent)student;
			System.out.println("minor of Undergraduate student: " +  underGraduateStudent.getMinor());
		}else if (student instanceof GraduateStudent) {
			GraduateStudent graduateStudent = (GraduateStudent)student;
			System.out.println("graduate student's advisor: " + graduateStudent.getAdvisor());
		}else {
			System.out.println("Student: " + student.getName());
		}
	}
	
	public List<Student> createStudents(){
		Student student;
		Date date = new Date();
		List<Student> students = new ArrayList<Student>();
		for(int i = 1; i < 10; i++) {
			student = new Student(i, "Kemal", 2000, date, "Computer Enginering");
			students.add(student);
		}
		return students;
	}

}
