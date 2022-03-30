package com.li.express.ecommerce.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.li.express.ecommerce.domain.ReservationId;
import com.li.express.ecommerce.domain.order.Order;
import com.li.express.ecommerce.domain.order.OrderId;
import com.li.express.ecommerce.domain.order.OrderRepository;
import com.li.express.ecommerce.domain.product.ProductId;

public class DomainOrderServiceTest {
	
	private DomainOrderService sut;
	
	@BeforeEach
	void setUp(){
		sut = new DomainOrderService(Mockito.mock(OrderRepository.class));
	}
	
	@Test
	void createOrder_whenIsValid_returnId(){
		Order order = new Order(new OrderId(1),  new ReservationId(1), new ProductId(1));
		assertEquals(1, sut.createOrder(order));
	}
	
	@Test
	void createOrder_whenReservationIsNotValid_throwsException(){
		Order order = new Order(new OrderId(1),  null, new ProductId(1));
    	assertThrows(IllegalArgumentException.class, ()->sut.createOrder(order));
	}
	
	@Test
    void createOrder_whenProductIsNotValid_throwsException(){
    	Order order = new Order(new OrderId(1), new ReservationId(2), null);
    	assertThrows(IllegalArgumentException.class, ()->sut.createOrder(order));
	}
    


}
