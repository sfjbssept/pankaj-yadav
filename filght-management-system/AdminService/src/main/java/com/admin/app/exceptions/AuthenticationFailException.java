package com.admin.app.exceptions;

public class AuthenticationFailException extends IllegalArgumentException{
	
	public AuthenticationFailException(String message) {
		super(message);
	}

}

