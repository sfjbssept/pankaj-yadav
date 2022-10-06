package com.user.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.app.entity.Ticket;
import com.user.app.repo.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public Optional<List<Ticket>> getTicketDetailByPNR(Integer pnr) {
		Optional<List<Ticket>> ticket = ticketRepository.findById(pnr);
		return ticket;
	}

	@Override
	public void confirmTicketByPNR(Integer flightPNR, String seatNumber, Date startDate, Date endDate) {
		Ticket ticket = new Ticket();
		ticket.setPNRnumber(flightPNR);
		ticket.setSeatNumber(seatNumber);
		ticket.setStartDateTime(startDate);
		ticket.setEndDateTime(endDate);
		ticketRepository.save(ticket);
	}

}
