package com.user.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.app.entity.Passenger;
import com.user.app.service.PassangerService;

@RestController
public class PassengerController {
	
	@Autowired
	PassangerService passangerService; 
	
	@GetMapping("/passengers")
	public ResponseEntity<List<Passenger>> getAllPassengers(){
		return new ResponseEntity<List<Passenger>>(passangerService.getPassangers(), HttpStatus.OK);
	}
	
	@DeleteMapping("/passenger/{pasId}")
	public ResponseEntity<String> addPassengers(@PathVariable Integer pasId){
		passangerService.deletePassenger(pasId);
		return new ResponseEntity<String>(pasId+" has been deleted", HttpStatus.OK);
	}
	
	

}
