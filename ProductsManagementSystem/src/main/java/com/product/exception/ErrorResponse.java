package com.product.exception;

public class ErrorResponse {
	
	private int errorCode;
	private String errorMessage;
	
	public ErrorResponse(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	

}
