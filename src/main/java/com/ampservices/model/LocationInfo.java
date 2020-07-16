package com.ampservices.model;

import java.util.List;

import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationInfo {

	private ObjectId _id;
	private String locationId;
	private List<String> availableDates;
	private List<String> availableTimes;
}
