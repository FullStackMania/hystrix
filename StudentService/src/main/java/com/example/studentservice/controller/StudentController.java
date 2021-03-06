package com.example.studentservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentservice.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	private static final List<Student> STUDENTS = Arrays.asList(new Student("1", "Rajesh", 1000, "Bangalore"),
			new Student("2", "Salman", 2000, "Noida"), new Student("3", "Himani", 3000, "Hydrabad"),
			new Student("4", "sujata", 4000, "kolkatta"));

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable("id") String id) throws InterruptedException {
		Thread.sleep(2000);
		for (Student s : STUDENTS) {
			if (s.getId().equals(id)) {
				return s;
			}
		}
		return null;
	}

}
