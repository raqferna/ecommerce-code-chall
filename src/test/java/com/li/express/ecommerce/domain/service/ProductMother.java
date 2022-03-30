package com.li.express.ecommerce.domain.service;

import java.util.ArrayList;

import com.github.javafaker.Faker;
import com.li.express.ecommerce.application.product.CreateProductRequest;
import com.li.express.ecommerce.domain.product.Product;
import com.li.express.ecommerce.domain.product.ProductDescription;
import com.li.express.ecommerce.domain.product.ProductId;
import com.li.express.ecommerce.domain.product.ProductOrderField;

public class ProductMother {
	private static Faker faker = new Faker();
	

	public static Product getRandomProduct() {
		return new Product(new ProductId(faker.number().randomDigit()),
				"random", new ProductDescription("fake"),111, new ArrayList<ProductOrderField>());
	}
	
	public static Product productFromRequest(ProductId id, CreateProductRequest prod) {
		 return  new Product
		     .ProductBuilder(id)
	        .productPrice(Long.valueOf(prod.getPrice()))
	        .productDescription(new ProductDescription(prod.getDescription()))
	        .productName(prod.getName())
	        .productOrderFields(prod.getProductOrderFields())
	        .build();
	}
}
