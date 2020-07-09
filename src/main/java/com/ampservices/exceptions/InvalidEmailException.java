package com.ampservices.exceptions;

public class InvalidEmailException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidEmailException(String emailId) {
		super(emailId);
	}

}
