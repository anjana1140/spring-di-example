package com.app.registration.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.app.registration.model.Student;
import com.app.registration.util.JdbcClient;

import oracle.net.aso.s;

public class StudentPersistDaoImpl implements StudentDao {
	
	//db connection
	
	Connection con;
	
	Statement statement;
	
	ResultSet resultSet;
	
	public static final String COL_STUDENT_ID = "STUDENT_ID";
	public static final String COL_STUDENT_NAME = "STUDENT_NAME";
	public static final String COL_STANDARD = "STANDARD";
	public static final String COL_SECTION = "SECTION";
	public static final String COL_SCHOOL = "SCHOOL";
	public static final String COL_CITY = "CITY";
	public static final String COL_PINCODE= "PINCODE";
	
	

	public StudentPersistDaoImpl() { 
		try {
			this.con = JdbcClient.getConnection();
			this.statement = con.createStatement();			
		} catch (SQLException e) {			
			e.printStackTrace();
		}	
	}


	

	@Override
	public String create(Student s) {
		String id = UUID.randomUUID().toString();
		int rowCount=0;
		String sql =""
				+ "INSERT INTO STUDENT"
				+ "	(STUDENT_ID, STUDENT_NAME, STANDARD, SECTION, SCHOOL, CITY, PINCODE) "
				+ "  VALUES "
				+ " ('"+id+"','"+s.getStudentName()+"','"+s.getStandard()+"','"+s.getSection()+"',"
						+ "'"+s.getSchool()+"','"+s.getCity()+"',"+s.getPincode()+")";			
		
		try {
			
			System.out.println("SQL: "+sql);
			rowCount =statement.executeUpdate(sql);
			
			if(rowCount>0) {
				System.out.println(rowCount+ " record created");
				return id;
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		
		return null;
	}

	@Override
	public void update(Student s) {
	
		String sql = "UPDATE STUDENT "
				+"SET STUDENT_NAME = '"+s.getStudentName()+"', STANDARD = '"+s.getStandard()+"' , SECTION = '"
				+s.getSection()+"' , SCHOOL = '"+s.getSchool()+"' , CITY = '"+s.getCity()+"', PINCODE = "+s.getPincode()
				+" WHERE student_id = '"+s.getStudentId()+"'";
		System.out.println("QUERY: "+sql);
		if(s==null || s.getStudentId() == null || s.getStudentId().isEmpty()) {
			
			throw new NullPointerException("Invalid Student Id");
		} else if(retrive(s.getStudentId()) == null) {
			
			throw new NullPointerException("No Record exists for this id ");
			
		}
		
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Student retrive(String id) {
		
		ResultSet res = null;
		
		Student student = null;
		
		String sql = "SELECT  * FROM student" 
				+ "  WHERE student_id = '"+id+"'";
		
		try {
		
			System.out.println("QUERY: "+sql);
			
		 res=	statement.executeQuery(sql);
		 
		 student = new Student();
		 while (res.next()) {
			student.setStudentId(id);		 
			student.setStudentName(res.getString(COL_STUDENT_NAME));
			student.setStandard(res.getString(COL_STANDARD) );
			student.setSection( res.getString(COL_SECTION));
			student.setSchool(res.getString(COL_SCHOOL));
			student.setCity(res.getString(COL_CITY));
			student.setPincode(res.getInt(COL_PINCODE));
		 }
		return student;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return null;
	}

	@Override
	public void delete(String id) {
		
		
	}

	@Override
	public List<Student> retriveAll() {
		List<Student> stuList = new ArrayList<>();
		String sql = "SELECT * FROM student";
		try {
			ResultSet res = statement.executeQuery(sql);			
			Student student = null;
			while (res.next()) {
				student = new Student();				 
				student.setStudentId(res.getString(COL_STUDENT_ID));				 
				student.setStudentName(res.getString(COL_STUDENT_NAME));
				student.setStandard(res.getString(COL_STANDARD) );
				student.setSection( res.getString(COL_SECTION));
				student.setSchool(res.getString(COL_SCHOOL));
				student.setCity(res.getString(COL_CITY));
				student.setPincode(res.getInt(COL_PINCODE));
				stuList.add(student);
			}
			return stuList;
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}




}
