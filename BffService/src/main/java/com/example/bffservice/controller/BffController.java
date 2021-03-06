package com.example.bffservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.bffservice.hystrixservice.StudentHystrixService;
import com.example.bffservice.hystrixservice.TeacherHystrixService;
import com.example.bffservice.model.Student;
import com.example.bffservice.model.StudentProfile;
import com.example.bffservice.model.Teacher;

@RestController
public class BffController {
	
	@Autowired
	private StudentHystrixService studentHystrixService;
	
	@Autowired
	private TeacherHystrixService teacherHystrixService;

	@GetMapping("/studentprofile/{id}")
	public StudentProfile getStudentProfile(@PathVariable("id") String id) {
		Student student = studentHystrixService.studentApiCall(id);
		Teacher teacher = teacherHystrixService.teacherApiCall();
		StudentProfile profile = new StudentProfile();
		profile.setStudentdetails(student);
		profile.setTeacherDetails(teacher);
		return profile;
	}


}
