package com.example.bffservice.hystrixservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.example.bffservice.model.Student;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class StudentHystrixService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallbackStudentProfile", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000") })
	public Student studentApiCall(String id) {
		return restTemplate.getForObject("http://localhost:8080/student/" + id, Student.class);
	}

	public Student fallbackStudentProfile(@PathVariable("id") String id) {
		Student s = new Student("harcoded student id", "hardcoded Student name", 1, "hardcoed Student address");
		return s;
	}

}
