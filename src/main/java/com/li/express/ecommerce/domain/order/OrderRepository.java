package com.li.express.ecommerce.domain.order;

import java.util.List;

import com.li.express.ecommerce.domain.ReservationId;
import com.li.express.ecommerce.domain.product.ProductId;


public interface OrderRepository {
	
	List<Order> findOrdersByReservationId(ReservationId id);
	
	int createOrder(Order order);
	
	OrderId nextOrderId();

}
