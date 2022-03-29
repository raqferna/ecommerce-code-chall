package com.li.express.ecommerce.application.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.li.express.ecommerce.domain.Product;

public class ProductsResponse implements Serializable{

	private static final long serialVersionUID = -3179820887309232223L;
	private List<ProductResponseData> data = new ArrayList<ProductResponseData>();
	
	public ProductsResponse (List<Product> products) {
		if(!products.isEmpty()) {
			products.forEach(product ->{
				data.add(ProductResponseData.fromProduct(product));	
			});
		}
	}
	
	public List<ProductResponseData> getData(){
		return this.data;
	}

}
