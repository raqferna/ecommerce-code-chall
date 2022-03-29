package com.li.express.ecommerce.application.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.li.express.ecommerce.domain.product.Product;
import com.li.express.ecommerce.domain.product.ProductDescription;
import com.li.express.ecommerce.domain.product.ProductOrderField;


public class CreateProductRequest implements Serializable{

	private static final long serialVersionUID = -288265803615629510L;
	private String name;
	private String description;
	String price;
	List<ProductFieldData> orderFields;
	
	public CreateProductRequest (String name,String description,String price, List<ProductFieldData> order_fields) {
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

	public 	List<ProductFieldData> getOrderFields() {
		return orderFields;
	}
	
	public List<ProductOrderField> getProductOrderFields(){
		List<ProductOrderField> orderFields = new ArrayList<ProductOrderField>();
		if(!this.orderFields.isEmpty()) {
			orderFields.forEach(order ->{
				orderFields.add(order);
			});
		}
		return orderFields;
	}
	
	


}
