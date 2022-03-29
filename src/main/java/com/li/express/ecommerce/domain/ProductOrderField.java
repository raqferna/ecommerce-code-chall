package com.li.express.ecommerce.domain;

public class ProductOrderField {
	
	private String name;
	private String type;
	
	public ProductOrderField( String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public void validateOrderField() {
		if(this.name == null || this.type == null) {
			//TODO THROWS CUSTOM EXCEPTION
		}
	}

}
