package com.ampservices.model;

import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurveyRequest {

	private ObjectId _id;
	private String rating;
	private String comment;
}
