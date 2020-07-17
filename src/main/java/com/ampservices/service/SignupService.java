package com.ampservices.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ampservices.dao.LatestUserId;
import com.ampservices.dao.RegisteredUsers;
import com.ampservices.exceptions.DuplicateUserException;
import com.ampservices.exceptions.FieldEmptyException;
import com.ampservices.exceptions.InvalidEmailException;
import com.ampservices.exceptions.PasswordMismatchException;
import com.ampservices.model.SignUpResponseModel;
import com.ampservices.model.SignupRequestModel;
import com.ampservices.mongorepositories.LatestUserIdRepository;
import com.ampservices.mongorepositories.RegisteredUsersRepository;

@Service
public class SignupService {
	
	@Autowired RegisteredUsersRepository registeredUsersRepository;
	@Autowired LatestUserIdRepository latestUserIdRepository;
	
	public ResponseEntity<SignUpResponseModel> registerUser(SignupRequestModel signupRequest)
			throws DuplicateUserException, FieldEmptyException, InvalidEmailException, PasswordMismatchException{
		
		
		//Validate the request
		if(StringUtils.isEmpty(signupRequest.getUserName())) {
			throw new FieldEmptyException("User Name is required!");
		} else if(StringUtils.isEmpty(signupRequest.getEmailId())) {
			throw new FieldEmptyException("Email Id is required!");
		} else if(StringUtils.isEmpty(signupRequest.getPassword())) {
			throw new FieldEmptyException("Password is required!");
		} else if(StringUtils.isEmpty(signupRequest.getConfirmPassword())) {
			throw new FieldEmptyException("Confirm Password is required!");
		} 
		
		String emailId = signupRequest.getEmailId();
		String pattern = "^(.+)@(.+)$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(emailId);
		if(!m.matches()) {
			throw new InvalidEmailException("Confirm Password");
		}
		
		
		String userName = signupRequest.getUserName();
		RegisteredUsers regUser = registeredUsersRepository.getUserByName(userName);
		if(regUser != null) {
			throw new DuplicateUserException(userName);
		}
		
		if(!signupRequest.getPassword().equals(signupRequest.getConfirmPassword())) {
			throw new PasswordMismatchException();
		}
		
		RegisteredUsers registeredUsers = new RegisteredUsers();
		registeredUsers.setUserName(signupRequest.getUserName());
		registeredUsers.setEmailId(signupRequest.getEmailId());
		registeredUsers.setPassword(signupRequest.getPassword());
		registeredUsers.setConfirmPassword(signupRequest.getConfirmPassword());
		
		LatestUserId latestUserId = latestUserIdRepository.getLatestUserId();
		int newUserId = latestUserId.getUserIdLastUsed() + 1;
		registeredUsers.setUserId(latestUserId.getUserIdLastUsed() + 1);
		latestUserId.setUserIdLastUsed(newUserId);
		
		latestUserIdRepository.save(latestUserId);
		registeredUsersRepository.save(registeredUsers);
		SignUpResponseModel responseModel = new SignUpResponseModel();
		responseModel.setUserName(registeredUsers.getUserName());
		responseModel.setLatestUserId(newUserId);
		
		ResponseEntity<SignUpResponseModel> response = new ResponseEntity<SignUpResponseModel>(responseModel,
				HttpStatus.OK);
		
		return response;
	}

}
