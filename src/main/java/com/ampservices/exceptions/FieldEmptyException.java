package com.ampservices.exceptions;

public class FieldEmptyException extends Exception {

	private static final long serialVersionUID = 1L;

	public FieldEmptyException(String fieldName) {
		super(fieldName);
	}
}
