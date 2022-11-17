package com.kube.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/hello")
	public String DisplayMessage() {
		return "Your app has been deployed on a container using k8";
	}
}
