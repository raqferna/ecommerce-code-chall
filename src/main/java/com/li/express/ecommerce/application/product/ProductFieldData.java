package com.li.express.ecommerce.application.product;

import java.io.Serializable;

import com.li.express.ecommerce.domain.product.ProductOrderField;

public class ProductFieldData implements Serializable{

	private static final long serialVersionUID = 1793934743911486614L;
	
	public String name;
	public String type;
	
	public ProductFieldData() {
		
	}

	public ProductFieldData(String name, String type) {
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