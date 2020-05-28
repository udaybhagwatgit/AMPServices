package com.ampservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ampservices.dao.LatestUserId;
import com.ampservices.dao.RegisteredUsers;
import com.ampservices.model.SignupRequestModel;
import com.ampservices.mongorepositories.LatestUserIdRepository;
import com.ampservices.mongorepositories.RegisteredUsersRepository;

@Service
public class SignupService {
	
	@Autowired RegisteredUsersRepository registeredUsersRepository;
	@Autowired LatestUserIdRepository latestUserIdRepository;
	
	public String registerUser(SignupRequestModel signupRequest) {
		
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
		
		return "Thanks for registering "+registeredUsers.getUserName()+". Your user id is "+newUserId;
	}

}
