package com.example.bffservice.hystrixservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.bffservice.model.Teacher;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TeacherHystrixService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallbackteacherProfile")
	public Teacher teacherApiCall() {
		return restTemplate.getForObject("http://localhost:8081/teacher", Teacher.class);
	}

	private Teacher fallbackteacherProfile() {
		Teacher t = new Teacher("hardcoded Teacher id", "Hardcoded Teacher name", "hardcoded Teeacher address");
		return t;
	}

}
