package com.admin.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Flight {
	
	@Id
	private Integer flightNumber;
	private String airline;
	private String flightSource;
	private String flightDestination;
	private Date startDateTime;
	private Date endDateTime;
	private String scheduledDays;
	private String instruments;
	private Integer businessClassSeat;
	private Integer nonBusinessClassSeat;
	private Double ticketFare;
	private Integer flightRows;
	private String mealType;
	
	
	public String getScheduledDays() {
		return scheduledDays;
	}
	public void setScheduledDays(String scheduledDays) {
		this.scheduledDays = scheduledDays;
	}
	public String getInstruments() {
		return instruments;
	}
	public void setInstruments(String instruments) {
		this.instruments = instruments;
	}
	public Integer getBusinessClassSeat() {
		return businessClassSeat;
	}
	public void setBusinessClassSeat(Integer businessClassSeat) {
		this.businessClassSeat = businessClassSeat;
	}
	public Integer getNonBusinessClassSeat() {
		return nonBusinessClassSeat;
	}
	public void setNonBusinessClassSeat(Integer nonBusinessClassSeat) {
		this.nonBusinessClassSeat = nonBusinessClassSeat;
	}
	public Double getTicketFare() {
		return ticketFare;
	}
	public void setTicketFare(Double ticketFare) {
		this.ticketFare = ticketFare;
	}
	public Integer getFlightRows() {
		return flightRows;
	}
	public void setFlightRows(Integer flightRows) {
		this.flightRows = flightRows;
	}
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public Integer getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFlightSource() {
		return flightSource;
	}
	public void setFlightSource(String flightSource) {
		this.flightSource = flightSource;
	}
	public String getFlightDestination() {
		return flightDestination;
	}
	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
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
	
	

}
