package com.ampservices.mongorepositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import com.ampservices.dao.ProductInfo;

@Component
public interface ProductsRepository extends MongoRepository<ProductInfo, String>{

	@Query("{}")
	List<ProductInfo> getProducts();
	
	@Query("{'skuid' : ?0}")
	ProductInfo getProductPrice(String skuid);
}
