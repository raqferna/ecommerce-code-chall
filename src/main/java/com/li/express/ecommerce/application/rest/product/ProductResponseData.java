package com.li.express.ecommerce.application.rest.product;

import java.util.Date;

import com.li.express.ecommerce.domain.Product;

public class ProductResponseData {
	public String id;
	public String name;
	public String description;
	public Date dateAdded;
	public String price;

	private ProductResponseData(String id, String name, String description, Date dateAdded, String price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.dateAdded = dateAdded;
		this.price = price;
	}
	
	public static ProductResponseData fromProduct(Product product) {
		return new ProductResponseData(convertToString(product.getProductId().value()), product.getProductName(), 
				product.getProductDescription().value(), product.getProductDateCreated(), 
				convertToString(product.getProductPrice()));
	}
	
	private static String convertToString(Object object) {
		return String.valueOf(object);
	}
}