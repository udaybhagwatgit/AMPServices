package com.ampservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ampservices.dao.PropertyInfo;
import com.ampservices.model.LocationInfo;
import com.ampservices.model.LocationsResponeModel;
import com.ampservices.model.ReservationModel;
import com.ampservices.mongorepositories.LocationInfoRepository;
import com.ampservices.mongorepositories.PropertiesRepository;
import com.ampservices.mongorepositories.ReservationRepository;

@Service
public class ReservationService {

	@Autowired PropertiesRepository propertiesRepository;
	@Autowired ReservationRepository reservationRepository;
	@Autowired LocationInfoRepository locationInfoRepository;
	
	public LocationsResponeModel getAvailableProperties() {
		List<PropertyInfo> properties = propertiesRepository.getProperties();
		LocationsResponeModel locationsResponeModel = new LocationsResponeModel();
		locationsResponeModel.setAvailableLocations(properties);
		return locationsResponeModel;
	}
	
	
	public LocationInfo getLocationInfo(String locationId) {
		LocationInfo locationInfo = locationInfoRepository.getLocationInfo(locationId);
		return locationInfo;
	}

	public ReservationModel reserveRoom(ReservationModel reservationModel) {
		reservationRepository.save(reservationModel);
		return reservationModel;
	}

}
