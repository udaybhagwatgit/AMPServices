package com.ampservices.mongorepositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ampservices.model.ReservationModel;

public interface ReservationRepository extends MongoRepository<ReservationModel, String>{

}
