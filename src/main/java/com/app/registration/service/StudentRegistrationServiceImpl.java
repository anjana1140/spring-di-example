package com.app.registration.service;

import java.util.List;

import com.app.registration.dao.StudentDao;
import com.app.registration.dao.StudentDaoImpl;
import com.app.registration.dao.StudentPersistDaoImpl;
import com.app.registration.model.Student;

public class StudentRegistrationServiceImpl implements StudentRegistrationService{
	
	private StudentDao studentDao;
	

	public StudentRegistrationServiceImpl() {
		//studentDao = new StudentDaoImpl();
		studentDao = new StudentPersistDaoImpl();
		
	}

	@Override
	public String registerStudent(String studentName, String standard, String section, String school,
			String city, int pincode) {
		Student s = new Student(studentName,standard,section,school,city,pincode);
		return studentDao.create(s);
	}

	@Override
	public void update(String studentId, String studentName, String standard, String section, String school,
			String city, int pincode) {
		
		Student s = new Student(studentId, studentName,standard,section,school,city,pincode);	
	    studentDao.update(s);
	}

	@Override
	public Student retrive(String id) {	
		return studentDao.retrive(id);
	}

	@Override
	public void delete(String id) {
		studentDao.delete(id);
		
	}

	@Override
	public List<Student> retriveAll() {
		
		return studentDao.retriveAll();
	}

	@Override
	public void deleteAll() {
		
		studentDao.deleteAll();
	
	}

}
