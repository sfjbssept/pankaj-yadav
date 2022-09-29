package com.admin.app.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//get flight list
	@GetMapping("/api/v1.0/flight/airline/list")
	public ResponseEntity<List<Flight>> listAllFlight(){
		List<Flight> registredflightList = adminService.getAllFlightDetails();
		return new ResponseEntity<List<Flight>>(registredflightList,HttpStatus.OK);
	}
	
	@GetMapping("/api/v1.0/flight/airline/{flightnumber}")
	public ResponseEntity<Flight> getFlight(@PathVariable Integer flightnumber){
		Optional<Flight> responseflight = adminService.getFLightbyId(flightnumber);
		return ResponseEntity.of(responseflight);
	}
	
	@DeleteMapping("/api/v1.0/flight/airline/{flightnumber}")
	public ResponseEntity<Flight> removeFlight(@PathVariable Integer flightnumber){
		adminService.deleteFlight(flightnumber);
		return new ResponseEntity<Flight>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/api/v1.0/flight/search")
	public ResponseEntity<List<Flight>> searchFlight(@RequestParam Map<String,String> allParams){
		List<Flight> responseFlightList = null;
		System.out.println("allParams: "+allParams);
		if(allParams.containsKey("source") && allParams.containsKey("destination")) {
			responseFlightList = userService.flightServiceBtweenDestinations(allParams.get("source"), allParams.get("destination"));
			System.out.println("Source is: "+allParams.get("source")+" \n destination is "+allParams.get("destination"));
		}
		return new ResponseEntity<List<Flight>>(responseFlightList,HttpStatus.OK);
	}
	

}
