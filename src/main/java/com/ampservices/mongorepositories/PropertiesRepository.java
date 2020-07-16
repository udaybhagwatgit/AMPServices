package com.ampservices.mongorepositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ampservices.dao.PropertyInfo;

public interface PropertiesRepository extends MongoRepository<PropertyInfo, String>{

	@Query("{}")
	List<PropertyInfo> getProperties();

}
