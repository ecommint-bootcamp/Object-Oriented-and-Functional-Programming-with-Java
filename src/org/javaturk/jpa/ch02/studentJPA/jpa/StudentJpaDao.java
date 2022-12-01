package org.javaturk.jpa.ch02.studentJPA.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.javaturk.jpa.ch02.studentJPA.contract.StudentDao;
import org.javaturk.jpa.ch02.studentJPA.domain.Student;
import org.javaturk.jpa.util.PersistenceUtil;

public class StudentJpaDao implements StudentDao{
	
	public StudentJpaDao() {
		PersistenceUtil.setPersistenceUnitName("ch02");
	}

	@Override
	public void saveStudent(Student student) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(student);
		tx.commit();
		em.close();
		
		System.out.println("Student saved!");
	}

	@Override
	public Student retrieveStudent(int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Student student = em.find(Student.class, id);
		
		em.close();
		if (student == null) {
			System.out.println("Student not found " + id);
			return null;
		} else {
			return student;
		}
	}

	@Override
	public List<Student> retrieveAllStudents() {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("Select s from Students s");
		List<Student> students = query.getResultList();
		em.close();
		return students;
	}

	@Override
	public void updateStudent(Student student) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Student updatedStudent = em.merge(student);
		if(updatedStudent == null){
			System.out.println("Student not found with id = " + student.getId());
		}
		else {
			System.out.println("Student updated!");
		}
		tx.commit();
		em.close();
	}

	@Override
	public void deleteStudent(int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Student studentToDelete = em.find(Student.class, id);
		if(studentToDelete == null){
			System.out.println("Student not found with id = " + id);
		}
		else{
			em.remove(studentToDelete);
			System.out.println("Student deleted!");
		}
		tx.commit();
		em.close();
	}

}
