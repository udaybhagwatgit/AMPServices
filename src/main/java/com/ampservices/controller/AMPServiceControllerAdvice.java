package com.ampservices.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ampservices.exceptions.DuplicateUserException;
import com.ampservices.exceptions.FieldEmptyException;
import com.ampservices.exceptions.InvalidEmailException;
import com.ampservices.exceptions.PasswordMismatchException;
import com.ampservices.model.SignUpErrorsResponseModel;

@ControllerAdvice(assignableTypes = AMPServicesController.class)
public class AMPServiceControllerAdvice {

	@ExceptionHandler(DuplicateUserException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody SignUpErrorsResponseModel handleDuplicateUserException(final DuplicateUserException exception,
			final HttpServletRequest request) {

		SignUpErrorsResponseModel error = new SignUpErrorsResponseModel();
		error.setMessage("User with "+exception.getMessage() + " already exists! Please choose a different username");
		error.setUri(request.getRequestURI());

		return error;
	}
	
	@ExceptionHandler(InvalidEmailException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody SignUpErrorsResponseModel handleInvalidEmailException(final InvalidEmailException exception,
			final HttpServletRequest request) {

		SignUpErrorsResponseModel error = new SignUpErrorsResponseModel();
		error.setMessage("The entered email "+exception.getMessage()+ " is in invalid format.");
		error.setUri(request.getRequestURI());

		return error;
	}
	
	@ExceptionHandler(FieldEmptyException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody SignUpErrorsResponseModel handleFieldEmptyException(final FieldEmptyException exception,
			final HttpServletRequest request) {

		SignUpErrorsResponseModel error = new SignUpErrorsResponseModel();
		error.setMessage(exception.getMessage());
		error.setUri(request.getRequestURI());

		return error;
	}
	
	@ExceptionHandler(PasswordMismatchException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody SignUpErrorsResponseModel handlePasswordMismatchException(final PasswordMismatchException exception,
			final HttpServletRequest request) {

		SignUpErrorsResponseModel error = new SignUpErrorsResponseModel();
		error.setMessage("Given passwords do not match!");
		error.setUri(request.getRequestURI());

		return error;
	}
}
