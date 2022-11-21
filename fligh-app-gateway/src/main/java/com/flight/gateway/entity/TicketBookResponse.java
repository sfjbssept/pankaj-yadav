package com.flight.gateway.entity;


public class TicketBookResponse {
	
	private String responseMessage;
	private String message;

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param responseMessage
	 * @param message
	 */
	public TicketBookResponse(String responseMessage, String message) {
		this.responseMessage = responseMessage;
		this.message = message;
	}
	
	
	
}
