package com.li.express.ecommerce.application.product;

import java.io.Serializable;
import java.util.List;

import com.li.express.ecommerce.application.order.OrderFieldData;


public class CreateProductRequest implements Serializable{

	private static final long serialVersionUID = -288265803615629510L;
	private String name;
	private String description;
	String price;
	List<OrderFieldData> orderFields;
	
	public CreateProductRequest (String name,String description,String price, List<OrderFieldData> order_fields) {
		this.name = name;
		this.description = description;
		this.price =price;
		this.orderFields = order_fields;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getPrice() {
		return price;
	}

	public 	List<OrderFieldData> getOrderFields() {
		return orderFields;
	}
	


}
