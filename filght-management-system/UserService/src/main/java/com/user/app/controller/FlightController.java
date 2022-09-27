package com.user.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.user.app.service.UserService;

@RestController
public class FlightController {

	@Autowired
	public UserService userService;
	
	
}
