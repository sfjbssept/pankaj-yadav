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
import com.admin.app.service.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	//new airline booking
	@PostMapping("/api/v1.0/flight/airline/register")
	public ResponseEntity<Flight> registerFlight(@RequestBody Flight flight){
		Flight registredflight = flightService.registerAirline(flight);
		return new ResponseEntity<Flight>(registredflight,HttpStatus.CREATED);
		
	}
	
	//get flight list
	@GetMapping("/api/v1.0/flight/airline/list")
	public ResponseEntity<List<Flight>> listAllFlight(){
		List<Flight> registredflightList = flightService.getAllFlightDetails();
		return new ResponseEntity<List<Flight>>(registredflightList,HttpStatus.OK);
	}
	
	@GetMapping("/api/v1.0/flight/airline/{flightnumber}")
	public ResponseEntity<Flight> getFlight(@PathVariable Integer flightnumber){
		Optional<Flight> responseflight = flightService.getFLightbyId(flightnumber);
		return ResponseEntity.of(responseflight);
	}
	
	@DeleteMapping("/api/v1.0/flight/airline/{flightnumber}")
	public ResponseEntity<String> removeFlight(@PathVariable Integer flightnumber){
		flightService.deleteFlight(flightnumber);
		return new ResponseEntity<String>("Resource has been deleted successfully",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/api/v1.0/flight/search")
	public ResponseEntity<List<Flight>> searchFlight(@RequestParam Map<String,String> allParams){
		List<Flight> responseFlightList = null;
		System.out.println("allParams: "+allParams);
		if(allParams.containsKey("source") && allParams.containsKey("destination")) {
			responseFlightList = flightService.flightServiceBtweenDestinations(allParams.get("source"), allParams.get("destination"));
			System.out.println("Source is: "+allParams.get("source")+" \n destination is "+allParams.get("destination"));
		}
		return new ResponseEntity<List<Flight>>(responseFlightList,HttpStatus.OK);
	}
	
//	@PostMapping("/api/v1.0/flight/booking/{flightNumber}")
//	public ResponseEntity<Boolean> bookFlight(@PathVariable Integer flightNumber, @RequestParam Map<String,String> userDetails){
//		String userName = userDetails.get("userName");
//		Integer seatCount = Integer.parseInt(userDetails.get("seatCount"));
//		String email = userDetails.get("email");
//		System.out.println("flightNumber:  "+flightNumber+"userName: "+userName+" seatCount: "+seatCount);
//
//		Boolean flightBookflag =  flightService.bookFlight(flightNumber, email, seatCount, email);
//		return new ResponseEntity<Boolean>(flightBookflag,HttpStatus.OK);
//	}
	
	

}
