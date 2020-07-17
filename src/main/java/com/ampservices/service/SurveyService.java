package com.ampservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ampservices.dao.SurveyResponse;
import com.ampservices.exceptions.FieldEmptyException;
import com.ampservices.model.SurveyRequest;
import com.ampservices.mongorepositories.SurveyQuestionnaireRepository;

@Service
public class SurveyService {
	
	@Autowired SurveyQuestionnaireRepository surveyQuestionnaireRepository;
	
	public SurveyResponse postSurvey(SurveyRequest surveyRequest) throws FieldEmptyException {
		
		if(StringUtils.isEmpty(surveyRequest.getRating())) {
			throw new FieldEmptyException("Please Rate us");
		}
		if(StringUtils.isEmpty(surveyRequest.getComment())) {
			throw new FieldEmptyException("Please enter your feedback");
		}
		
		surveyQuestionnaireRepository.save(surveyRequest);
		SurveyResponse surveyResponse = new SurveyResponse();
		surveyResponse.setMessage("Thank you for your feedback!");
		return surveyResponse;
	}

}
