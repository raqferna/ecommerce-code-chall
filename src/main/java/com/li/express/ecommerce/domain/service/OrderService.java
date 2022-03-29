package com.li.express.ecommerce.domain.service;

import java.util.List;

import com.li.express.ecommerce.domain.Order;
import com.li.express.ecommerce.domain.ReservationId;



public interface OrderService {

	List<Order> findOrdersByReservationId(ReservationId id);
	int createOrder(Order order);
	
}
