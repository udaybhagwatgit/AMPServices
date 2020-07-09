package com.ampservices.exceptions;

public class DuplicateUserException extends Exception {

	private static final long serialVersionUID = 1L;

	public DuplicateUserException(String userName) {
		super(userName);
	}
}
