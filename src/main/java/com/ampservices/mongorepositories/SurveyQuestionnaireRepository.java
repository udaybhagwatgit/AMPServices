package com.ampservices.mongorepositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.ampservices.model.SurveyRequest;

@Component
public interface SurveyQuestionnaireRepository extends MongoRepository<SurveyRequest, String> {
	
	

}
