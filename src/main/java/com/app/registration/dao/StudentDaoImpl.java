package com.app.registration.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.app.registration.model.Student;

public class StudentDaoImpl implements StudentDao {

	private Map<String, Student> studentDB = new HashMap<>();

	@Override
	public String create(Student s) {

		String id = UUID.randomUUID().toString();
		s.setStudentId(id);
		studentDB.put(id, s);
		return id;
	}

	@Override
	public void update(Student s) {
		if (studentDB.containsKey(s.getStudentId()))
			studentDB.put(s.getStudentId(), s);
		else
			System.out.println("Student recored doesn't exist!!");

	}

	@Override
	public Student retrive(String id) {

		return studentDB.get(id);
	}

	@Override
	public void delete(String id) {

		studentDB.remove(id);

	}

	@Override
	public List<Student> retriveAll() {
		List<Student> studentList = new ArrayList<Student>(studentDB.values());
		return studentList;
	}

	@Override
	public void deleteAll() {
		
		studentDB.clear();
	}

}
