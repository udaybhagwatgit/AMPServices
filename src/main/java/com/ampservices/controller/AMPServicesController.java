package com.ampservices.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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

	
	@CrossOrigin(origins = "*", allowedHeaders = "AMP-Access-Control-Allow-Source-Origin")
	@RequestMapping(method = RequestMethod.POST, value = "/ampService/signUp", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SignUpResponseModel> signUpUser(SignupRequestModel signupRequest) {
		SignUpResponseModel responseObject = service.registerUser(signupRequest);
		ResponseEntity<SignUpResponseModel> responseEntity = new ResponseEntity<SignUpResponseModel>(responseObject,
				HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ampService/test")
	public ResponseEntity<String> testUser() {
		String responseObject = "Hello AMP Test";
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(responseObject, HttpStatus.OK);
		return responseEntity;
	}

}
