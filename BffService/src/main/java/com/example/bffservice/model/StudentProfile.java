package com.example.bffservice.model;

public class StudentProfile {

	private Student studentDetails;

	private Teacher teacherDetails;

	public Teacher getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(Teacher teacherDetails) {
		this.teacherDetails = teacherDetails;
	}

	public Student getStudentdetails() {
		return studentDetails;
	}

	public void setStudentdetails(Student studentDetails) {
		this.studentDetails = studentDetails;
	}

}
