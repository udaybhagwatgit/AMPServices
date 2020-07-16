package com.ampservices.dao;

import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyInfo {
	private ObjectId _id;
	private String location;
	private String locationId;
	
}
