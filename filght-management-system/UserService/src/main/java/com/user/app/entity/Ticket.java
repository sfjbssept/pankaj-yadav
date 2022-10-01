package com.user.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
	
	//private departure and arrival details, PNR and booking code, seat number, and boarding time
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer TicketCode;
	private Date startDateTime;
	private Date endDateTime;
	private Integer PNRnumber;
	private String seatNumber;
	public Integer getTicketCode() {
		return TicketCode;
	}
	public void setTicketCode(Integer ticketCode) {
		TicketCode = ticketCode;
	}
	public Date getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}
	public Date getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
	public Integer getPNRnumber() {
		return PNRnumber;
	}
	public void setPNRnumber(Integer pNRnumber) {
		PNRnumber = pNRnumber;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	
}
