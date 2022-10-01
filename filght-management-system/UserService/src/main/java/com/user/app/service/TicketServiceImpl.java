package com.user.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.app.entity.Ticket;
import com.user.app.repo.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public Ticket getTicketDetailByPNR(Integer pnr) {
		ticketRepository.findById(pnr);
		return null;
	}

	@Override
	public void confirmTicketByPNR(Integer flightPNR, String seatNumber) {
		// TODO Auto-generated method stub
		
	}

}
