package com.admin.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.admin.app.entity.Flight;
import com.admin.app.service.AdminService;

@RestController
public class FlightController {
	
	@Autowired
	AdminService adminService;
	
	//new airline booking
	@PostMapping("/api/v1.0/flight/airline/register")
	public ResponseEntity<Flight> registerFlight(@RequestBody Flight flight){
		Flight registredflight = adminService.registerAirline(flight);
		return new ResponseEntity<Flight>(registredflight,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/api/v1.0/flight/airline/list")
	public ResponseEntity<List<Flight>> listAllFlight(){
		List<Flight> registredflightList = adminService.getAllFlightDetails();
		return new ResponseEntity<List<Flight>>(registredflightList,HttpStatus.OK);
		
	}
	
	

}
