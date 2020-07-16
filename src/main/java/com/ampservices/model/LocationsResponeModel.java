package com.ampservices.model;

import java.util.List;

import com.ampservices.dao.PropertyInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationsResponeModel {
	private List<PropertyInfo> availableLocations;
}
