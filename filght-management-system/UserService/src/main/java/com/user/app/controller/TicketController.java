package com.user.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.app.entity.Passenger;
import com.user.app.entity.Ticket;
import com.user.app.service.TicketService;

@RestController
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@GetMapping("/api/v1.0/flight/ticket/{pnr}")
	public ResponseEntity<Ticket> getTicketByPNR(@PathVariable Integer pnr, @RequestBody List<Passenger> passangerDetails ){
		
		Ticket tkt = ticketService.getTicketDetailByPNR(pnr);
		return new ResponseEntity<Ticket>(tkt,HttpStatus.OK);
	}

}
