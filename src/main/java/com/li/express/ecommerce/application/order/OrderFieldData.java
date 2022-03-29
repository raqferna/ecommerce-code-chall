package com.li.express.ecommerce.application.order;

import java.io.Serializable;

import com.li.express.ecommerce.domain.product.ProductOrderField;

public class OrderFieldData implements Serializable{

	private static final long serialVersionUID = 1793934743911486614L;
	
	public String name;
	public String type;

	public OrderFieldData(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}
	
	public ProductOrderField getProductOrderField() {
		return new ProductOrderField(this.name, this.type);
	}
}