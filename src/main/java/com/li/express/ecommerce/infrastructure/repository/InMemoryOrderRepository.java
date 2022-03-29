package com.li.express.ecommerce.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.li.express.ecommerce.domain.ReservationId;
import com.li.express.ecommerce.domain.order.Order;
import com.li.express.ecommerce.domain.order.OrderRepository;

@Repository
@Primary
public class InMemoryOrderRepository implements OrderRepository{
	
	List<Order> orders = new ArrayList<>();

	@Override
	public List<Order> findOrdersByReservationId(ReservationId id) {
		return orders.stream().filter( order -> order.getReservationId().equals(id)).collect(Collectors.toList());
	}

	@Override
	public int createOrder(Order order) {
		orders.add(order);
	    return order.getOrderId().value();
	}
	

}
