package com.li.express.ecommerce.application.product;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.li.express.ecommerce.domain.product.Product;

public class ProductResponseData {
	
	private static String DATE_PATTERN = "dd/MM/yyyy HH:mm:ss";
	public String id;
	public String name;
	public String description;
	public String dateAdded;
	public String price;

	private ProductResponseData(String id, String name, String description, Date dateAdded, String price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.dateAdded = formatDate(dateAdded);
		this.price = price;
	}
	
	private  String formatDate(Date dateAdded) {
		DateFormat df = new SimpleDateFormat(DATE_PATTERN);
		return df.format(dateAdded);
	}
	
	public static ProductResponseData fromProduct(Product product) {
		return new ProductResponseData(convertToString(product.getProductId().value()), product.getProductName(), 
				product.getProductDescription().value(), product.getDateCreated(), 
				convertToString(product.getProductPrice()));
	}
	
	private static String convertToString(Object object) {
		return String.valueOf(object);
	}
}