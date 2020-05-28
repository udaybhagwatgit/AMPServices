package com.ampservices.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class RegisteredUsers {
	private ObjectId _id;
	private String userName;
	private String emailId;
	private String password;
	private String confirmPassword;
	private int userId;
}
