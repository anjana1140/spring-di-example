package com.app.registration.dao;

import java.util.List;

import com.app.registration.model.Student;

public interface StudentDao {

	String create(Student s);

	void update(Student s);

	Student retrive(String id);

	void delete(String id);

	List<Student> retriveAll();

	void deleteAll();

}
