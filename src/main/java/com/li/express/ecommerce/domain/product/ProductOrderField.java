package com.li.express.ecommerce.domain.product;

public class ProductOrderField {
	
	private String name;
	private String type;
	
	public ProductOrderField( String name, String type) {
		validateOrderField(name, type);
		this.name = name;
		this.type = type;
	}
	
	public void validateOrderField(String name, String type) {
		if(name == null || type == null) {
		  throw new IllegalArgumentException("validateOrderField Error");
		}
	}
	
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

}
