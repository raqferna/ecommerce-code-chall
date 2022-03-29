package com.li.express.ecommerce.application.product;

import java.util.ArrayList;
import java.util.List;

import com.li.express.ecommerce.domain.product.Product;
import com.li.express.ecommerce.domain.product.ProductDescription;
import com.li.express.ecommerce.domain.product.ProductOrderField;

public class ProductDetailReponse {
	

    private String name;    

	private String description;
    private String price;
    private List<ProductFieldData> order_fields;
    
    public ProductDetailReponse(String name,String description,String price, List<ProductFieldData> fields) {
		this.name = name;
		this.description = description;
		this.price =price;
		this.order_fields = fields;
	}
	
	
	public ProductDetailReponse() {
	
	}


	public static ProductDetailReponse fromProduct(Product product) {
		return new ProductDetailReponse(product.getProductName(), product.getProductDescription().value(),
				String.valueOf(product.getProductPrice()), getProductOrderFields(product.getProductOrderFields()));
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


	public List<ProductFieldData> getOrder_fields() {
		return order_fields;
	}

	
	private static  List<ProductFieldData> getProductOrderFields(List<ProductOrderField> fields){
		List<ProductFieldData> orderFields = new ArrayList<ProductFieldData>();
		if(fields.isEmpty()) {
			orderFields.forEach(order ->{
				orderFields.add(order);
			});
		}
		return orderFields;
	}
	

}
