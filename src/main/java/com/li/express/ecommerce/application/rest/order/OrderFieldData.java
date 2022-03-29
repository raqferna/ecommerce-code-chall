package com.li.express.ecommerce.application.rest.order;

import java.io.Serializable;

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
}