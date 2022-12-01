package org.javaturk.jpa.ch02.studentJPA.contract;

import java.util.List;

import org.javaturk.jpa.ch02.studentJPA.domain.Student;

public interface StudentDao {

	public void saveStudent(Student student);
	
	public Student retrieveStudent(int id);
	
	public List<Student> retrieveAllStudents();
	
	public void updateStudent(Student student);
	
	public void deleteStudent(int id);
}
