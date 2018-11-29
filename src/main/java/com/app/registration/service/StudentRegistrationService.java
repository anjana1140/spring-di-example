package com.app.registration.service;

import java.util.List;

import com.app.registration.model.Student;

public interface StudentRegistrationService {
	
	String  registerStudent(String studentName, String standard,	String section,	String school,	String city, int pincode);
	
	void update(String studentId, String studentName, String standard,	String section,	String school,	String city, int pincode);
	 
	Student  retrive(String id);
	
	void delete(String id);
	
	List<Student> retriveAll();
	
	void deleteAll();

}
