package com.deploy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeployController {
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello My Name Is Pankaj Yadav";
	}
	
	@GetMapping("/{name}")
	public String helloName(@PathVariable String name) {
		return "Hello My Name Is "+name;
	}

}
