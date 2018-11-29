package com.app.registration.model;

public class Student {

	String studentId;
	String studentName;
	String standard;
	String section;
	String school;
	String city;
	int pincode;

	public Student() {
	}

	public Student(String studentName, String standard, String section, String school, String city, int pincode) {
		super();
		this.studentName = studentName;
		this.standard = standard;
		this.section = section;
		this.school = school;
		this.city = city;
		this.pincode = pincode;
	}

	


	public Student(String studentId, String studentName, String standard, String section, String school, String city,
			int pincode) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.standard = standard;
		this.section = section;
		this.school = school;
		this.city = city;
		this.pincode = pincode;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(this.studentId);
		sb.append(",");
		sb.append(this.studentName);
		sb.append(",");
		sb.append(this.standard);
		sb.append(",");
		sb.append(this.section);
		sb.append(",");
		sb.append(this.school);
		sb.append(",");
		sb.append(this.city);
		sb.append(",");
		sb.append(this.pincode);
		sb.append("]");
		
		return sb.toString();
	}
	

}
