package com.user.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.user.app.entity.Ticket;

public interface TicketService {

	List<Ticket> getTicketDetailByPNR(Integer pnr);

	void confirmTicketByPNR(Integer flightPNR, String seatNumber, Date startDate, Date endDate);

}
