package com.ampservices.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class SignupRequestModel {
	private String userName;
	private String emailId;
	private String password;
	private String confirmPassword;
}
