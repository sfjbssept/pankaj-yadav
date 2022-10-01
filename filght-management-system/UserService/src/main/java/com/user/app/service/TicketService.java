package com.user.app.service;

import com.user.app.entity.Ticket;

public interface TicketService {

	Ticket getTicketDetailByPNR(Integer pnr);

	void confirmTicketByPNR(Integer flightPNR, String seatNumber);

}
