package com.ampservices.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class ProductInfo {
	private ObjectId _id;
	private String skuid;
	private String name;
	private String image;
	private String linkUrl;
	private int price;

}
