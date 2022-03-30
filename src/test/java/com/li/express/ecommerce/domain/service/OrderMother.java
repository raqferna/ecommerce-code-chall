package com.li.express.ecommerce.domain.service;

import com.github.javafaker.Faker;
import com.li.express.ecommerce.domain.ReservationId;
import com.li.express.ecommerce.domain.order.Order;
import com.li.express.ecommerce.domain.order.OrderId;
import com.li.express.ecommerce.domain.product.ProductId;

public class OrderMother {
	
	private static Faker faker = new Faker();
	
	public static Order getParamOrder(int prodId, int resId) {
		return new Order(new OrderId(faker.number().randomDigit()), new ReservationId(resId), new ProductId(prodId));
		
	}

}
