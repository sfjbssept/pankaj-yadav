package com.user.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.app.entity.Passenger;
import com.user.app.entity.Ticket;
import com.user.app.repo.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<Ticket> getTicketDetailByPNR(Integer pnr) {
		List<Ticket> ticketList = ticketRepository.findBypnr(pnr);
		return ticketList;
	}

	@Override
	public void confirmTicketByPNR(Integer flightPNR,String ticketStaus, String seatNumber, Date startDate, Date endDate) {
		Ticket ticket = new Ticket();
		ticket.setPNRnumber(flightPNR);
		ticket.setTicketStatus(ticketStaus);
		ticket.setSeatNumber(seatNumber);
		ticket.setStartDateTime(startDate);
		ticket.setEndDateTime(endDate);
		ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> cancelTicketDetailByPNR(Integer pnr, String ticketStaus) {
		List<Ticket> tktListResponse = new ArrayList<>();
		
		List<Integer> ticketIds= ticketRepository.findidBypnr(pnr);
		List<Ticket> tkts = ticketRepository.findAllById(ticketIds);
		
		ListIterator<Ticket> iterator = tkts.listIterator();
		while (iterator.hasNext()) {
			Ticket t = iterator.next();
			t.setTicketStatus(ticketStaus);
			tktListResponse.add(t);
		}
				
		for (Integer tkt : ticketIds) {
			ticketRepository.deleteById(tkt);
		}
		return tktListResponse;
	}

}
