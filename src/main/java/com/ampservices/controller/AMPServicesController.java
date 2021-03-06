package com.ampservices.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.ampservices.dao.ProductInfo;
import com.ampservices.dao.PropertyInfo;
import com.ampservices.model.LocationInfo;
import com.ampservices.model.ReservationModel;
import com.ampservices.model.LocationsResponeModel;
import com.ampservices.service.ReservationService;
import com.ampservices.exceptions.DuplicateUserException;
import com.ampservices.exceptions.FieldEmptyException;
import com.ampservices.exceptions.InvalidEmailException;
import com.ampservices.exceptions.PasswordMismatchException;
import com.ampservices.model.SignUpResponseModel;
import com.ampservices.model.SignupRequestModel;
import com.ampservices.service.ProductService;
import com.ampservices.service.SignupService;
import com.ampservices.service.SurveyService;
import com.ampservices.model.SurveyRequest;
import com.ampservices.dao.SurveyResponse;

@RestController
public class AMPServicesController {

	@Autowired
	SignupService service;
	@Autowired ReservationService reservationService;
	@Autowired
	SurveyService surveyService;
	@Autowired
	ProductService productService;

	
	@RequestMapping(method = RequestMethod.POST, value = "/ampService/signUp", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SignUpResponseModel> signUpUser(SignupRequestModel signupRequest) throws DuplicateUserException, FieldEmptyException, InvalidEmailException, PasswordMismatchException {
		ResponseEntity<SignUpResponseModel> responseEntity = null;
		try {
			responseEntity = service.registerUser(signupRequest);
			return responseEntity;
		} catch (DuplicateUserException e) {
			throw new DuplicateUserException(signupRequest.getUserName());
		} catch (FieldEmptyException ex) {
			throw new FieldEmptyException(ex.getMessage());
		} catch (InvalidEmailException exx) {
			throw new InvalidEmailException(signupRequest.getEmailId());
		} catch (PasswordMismatchException exxx) {
			throw new PasswordMismatchException();
		}
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ampService/test")
	public ResponseEntity<String> testUser() {
		String responseObject = "Hello AMP Test";
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(responseObject, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ampService/getAvailableProperties")
	public ResponseEntity<LocationsResponeModel> getPropertyList() {
		LocationsResponeModel properties = reservationService.getAvailableProperties();
		ResponseEntity<LocationsResponeModel> responseEntity = new ResponseEntity<LocationsResponeModel>(properties,
				HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ampService/getLocationInfo/{locationId}")
	public ResponseEntity<LocationInfo> getLocationInfo(@PathVariable final String locationId) {
		LocationInfo locationInfo = reservationService.getLocationInfo(locationId);
		ResponseEntity<LocationInfo> responseEntity = new ResponseEntity<LocationInfo>(locationInfo,
				HttpStatus.OK);
		return responseEntity;
	}


	@RequestMapping(method = RequestMethod.POST, value = "/ampService/reserveRoom")
	public ResponseEntity<ReservationModel> reserveRoom(ReservationModel reservationModel) {
		ReservationModel reservation = reservationService.reserveRoom(reservationModel);
		ResponseEntity<ReservationModel> responseEntity = new ResponseEntity<ReservationModel>(
				reservation, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/ampService/postSurvey")
	public ResponseEntity<SurveyResponse> postSurvey(SurveyRequest surveyRequest) throws FieldEmptyException {
		SurveyResponse surveyResponse = surveyService.postSurvey(surveyRequest);
		ResponseEntity<SurveyResponse> responseEntity = new ResponseEntity<SurveyResponse>(
				surveyResponse, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ampService/getProducts")
	public ResponseEntity<Map<String, List<ProductInfo>>> getProducts() {
		List<ProductInfo> responseObject = productService.getProductsList();
		Map<String, List<ProductInfo>> responseMap = new HashMap<>();
		responseMap.put("products", responseObject);
		ResponseEntity<Map<String, List<ProductInfo>>> responseEntity = new ResponseEntity<Map<String, List<ProductInfo>>>(responseMap,
				HttpStatus.OK);
		return responseEntity;
	}
	
		@RequestMapping(method = RequestMethod.GET, value = "/ampService/getProduct/{skuid}")
	public ResponseEntity<ProductInfo> getProduct(@PathVariable final String skuid) {
		ProductInfo responseObject = productService.getProductPrice(skuid);
		ResponseEntity<ProductInfo> responseEntity = new ResponseEntity<ProductInfo>(responseObject, HttpStatus.OK);
		return responseEntity;
	}


}
