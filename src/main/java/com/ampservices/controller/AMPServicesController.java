package com.ampservices.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ampservices.model.SignupRequestModel;
import com.ampservices.service.SignupService;

@RestController
public class AMPServicesController {

	@Autowired
	SignupService service;

	@RequestMapping(method = RequestMethod.POST, value = "/ampService/signUp")
	public ResponseEntity<String> signUpUser(@RequestBody final SignupRequestModel signupRequest) {
		String responseObject = service.registerUser(signupRequest);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(responseObject, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/ampService/test")
	public ResponseEntity<String> signUpUser(@RequestBody final SignupRequestModel signupRequest) {
		String responseObject = "Hello AMP Test";
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(responseObject, HttpStatus.OK);
		return responseEntity;
	}


	@CrossOrigin()
	@RequestMapping(value = "/ampService/*", method = RequestMethod.OPTIONS)
	public void corsHeaders(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
		response.addHeader("Access-Control-Max-Age", "3600");
	}
}
