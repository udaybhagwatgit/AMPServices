package com.ampservices.mongorepositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import com.ampservices.dao.RegisteredUsers;


@Component
public interface RegisteredUsersRepository extends MongoRepository<RegisteredUsers, String> {
	
	 @Query("{ $and: [{ 'emailId' : ?0 }]}")
	 RegisteredUsers getUser(String emailId);
	
	 @Query("{ $and: [{ 'userName' : ?0 }]}")
	 RegisteredUsers getUserByName(String userName);

}
