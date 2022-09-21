package com.eserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/getschooldetail/{schoolname}")
//	@RequestMapping(value="/getschooldetail/{schoolname}",method = RequestMethod.GET)
	public String getStudents(@PathVariable String schoolname) {
		System.out.println("getting school details for "+schoolname);
		
		String response = restTemplate.exchange("http://school-service/schooldetail/{schoolname}", HttpMethod.GET
				,null,new ParameterizedTypeReference<String>() {
				},schoolname).getBody();
		
		System.out.println("Response received as : "+response);
		
		return "School name "+schoolname+ "\n student details "+response;
	}

}
