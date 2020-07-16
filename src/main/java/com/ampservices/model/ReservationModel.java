package com.ampservices.model;

import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationModel {

	private ObjectId _id;
	private String location;
	private String selectedDate;
	private String selectedTime;
}
