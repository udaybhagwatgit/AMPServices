package com.ampservices.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class LatestUserId {
	private ObjectId _id;
	private int userIdLastUsed;
}
