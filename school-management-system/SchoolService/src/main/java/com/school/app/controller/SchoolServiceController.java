package com.school.app.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/schooldetail")
public class SchoolServiceController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(value="/{schooldname}")
	public String getStudents(@PathVariable("schooldname") String schooldname) {
		System.out.println("Getting school details for "+schooldname);
		String requestUrl = "http://localhost:9091/getStudentDetailsForSchool/"+schooldname;
		
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		
		ResponseEntity<String> response = restTemplate.exchange(requestUrl, HttpMethod.GET, httpEntity, String.class);
		String student = response.getBody();
		System.out.println("response received as "+student);
		return "School name: "+schooldname+ "\n STudent details "+ student;
	}

}
