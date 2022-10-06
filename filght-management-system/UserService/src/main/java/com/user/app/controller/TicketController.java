package com.user.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.user.app.entity.Ticket;
import com.user.app.service.TicketService;

@RestController
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
//	@GetMapping("/api/v1.0/flight/ticket/{pnr}")
//	public ResponseEntity<Ticket> getTicketByPNR(@PathVariable Integer pnr){
//		
//		Optional<Ticket> tkt = ticketService.getTicketDetailByPNR(pnr);
//		System.out.println(tkt.get().getSeatNumber());
//		return ResponseEntity.of(tkt);
//	}

}
