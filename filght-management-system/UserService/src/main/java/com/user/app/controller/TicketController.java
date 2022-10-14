package com.user.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.user.app.entity.Ticket;
import com.user.app.service.TicketService;

@RestController
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@DeleteMapping("/api/v1.0/flight/booking/cancel/{pnr}")
	public ResponseEntity<List<Ticket>> cancelTicketByPNR(@PathVariable Integer pnr){
		
		String ticketStaus = "CANCELLED";
		
		List<Ticket> tkt = ticketService.cancelTicketDetailByPNR(pnr,ticketStaus);
		return new ResponseEntity<List<Ticket>>(tkt,HttpStatus.ACCEPTED);
	}

}
