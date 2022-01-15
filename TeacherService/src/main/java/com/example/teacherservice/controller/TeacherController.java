package com.example.teacherservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teacherservice.model.Teacher;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@GetMapping
	public Teacher getTeacher() {
		return new Teacher("1", "Guruji", "Bangalore");
	}

}
