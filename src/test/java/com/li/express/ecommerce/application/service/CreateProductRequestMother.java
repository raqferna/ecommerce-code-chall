package com.li.express.ecommerce.application.service;

import java.util.ArrayList;

import com.github.javafaker.Faker;
import com.li.express.ecommerce.application.product.CreateProductRequest;
import com.li.express.ecommerce.application.product.ProductFieldData;

public class CreateProductRequestMother {
	
	public static CreateProductRequest CreateRandomProductRequest () {
		return new CreateProductRequest (Faker.instance().name().name(), Faker.instance().beer().malt(),"12",
				new ArrayList<ProductFieldData>());
	}
}
