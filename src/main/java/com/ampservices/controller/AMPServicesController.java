package com.ampservices.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ampservices.model.SignUpResponseModel;
import com.ampservices.model.SignupRequestModel;
import com.ampservices.service.SignupService;

@RestController
public class AMPServicesController {

	@Autowired
	SignupService service;

	
	@RequestMapping(method = RequestMethod.POST, value = "/ampService/signUp", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SignUpResponseModel> signUpUser(SignupRequestModel signupRequest) {
		SignUpResponseModel responseObject = service.registerUser(signupRequest);
		ResponseEntity<SignUpResponseModel> responseEntity = new ResponseEntity<SignUpResponseModel>(responseObject,
				HttpStatus.OK);
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		headers.add("AMP-Access-Control-Allow-Source-Origin", "sameer.patil2@qa.amp.epsilon.com");
		headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
		headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, DELETE, OPTIONS");
		headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "origin, content-type, accept, x-requested-with, AMP-Access-Control-Allow-Source-Origin");
		headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "AMP-Access-Control-Allow-Source-Origin");
		headers.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "3600");
		return ResponseEntity.ok().headers(headers).body(responseObject);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ampService/test")
	public ResponseEntity<String> testUser() {
		String responseObject = "Hello AMP Test";
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(responseObject, HttpStatus.OK);
		return responseEntity;
	}

}
