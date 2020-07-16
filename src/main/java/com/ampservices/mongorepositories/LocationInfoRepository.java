package com.ampservices.mongorepositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ampservices.model.LocationInfo;

public interface LocationInfoRepository extends MongoRepository<LocationInfo, String>{

	@Query("{'locationId' : ?0}")
	LocationInfo getLocationInfo(String locationId);

}
