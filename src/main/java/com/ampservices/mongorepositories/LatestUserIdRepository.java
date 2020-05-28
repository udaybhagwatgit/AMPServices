package com.ampservices.mongorepositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ampservices.dao.LatestUserId;

public interface LatestUserIdRepository extends MongoRepository<LatestUserId, String> {
	
	 @Query("{}")
	 LatestUserId getLatestUserId();

}

