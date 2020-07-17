package com.ampservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ampservices.dao.ProductInfo;
import com.ampservices.mongorepositories.ProductsRepository;

@Service
public class ProductService {

	@Autowired ProductsRepository productsRepository;
	
	public List<ProductInfo> getProductsList() {
		return productsRepository.getProducts();
	}
	
	public ProductInfo getProductPrice(String skuid) {
		return productsRepository.getProductPrice(skuid);
	}
}
