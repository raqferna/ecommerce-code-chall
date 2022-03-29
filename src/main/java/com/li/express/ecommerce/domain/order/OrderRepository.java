package com.li.express.ecommerce.domain.order;

import java.util.List;

import com.li.express.ecommerce.domain.ReservationId;


public interface OrderRepository {
	
	List<Order> findOrdersByReservationId(ReservationId id);
	int createOrder(Order order);

}
