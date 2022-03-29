package com.li.express.ecommerce.domain;

import java.util.List;


public interface OrderRepository {
	
	List<Order> findOrdersByReservationId(ReservationId id);
	int createOrder(Order order);

}
