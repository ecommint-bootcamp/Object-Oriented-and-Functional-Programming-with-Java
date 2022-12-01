package org.javaturk.jpa.ch02.studentJPA.jpa;

import java.util.Date;
import java.util.List;

import org.javaturk.jpa.ch02.studentJPA.domain.Student;

public class Test {

	public static void main(String[] args) {
		StudentJpaDao dao = new StudentJpaDao();

		Student student = new Student(10, "Uğur", "Kılıç", 1995, new Date(), 3.56);
		dao.saveStudent(student);

		List<Student> students = dao.retrieveAllStudents();
		for (Student student1 : students)
			System.out.println(student1);

		Student retrievedStudent = dao.retrieveStudent(10);
		if (retrievedStudent == null)
			System.out.println("Student not found");
		else
			System.out.println(retrievedStudent);
		
		Student updatedStudent = dao.retrieveStudent(10);
		System.out.println("Before update: " + updatedStudent);
		updatedStudent.setDob(new Date(100));
		dao.updateStudent(updatedStudent);
		System.out.println("After update" + updatedStudent);

		dao.deleteStudent(10);

	}

}
