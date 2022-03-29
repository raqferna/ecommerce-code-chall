package com.li.express.ecommerce.domain.service;

import java.util.List;

import com.li.express.ecommerce.domain.ReservationId;
import com.li.express.ecommerce.domain.order.Order;
import com.li.express.ecommerce.domain.order.OrderRepository;


public class DomainOrderService implements OrderService{
	
	private final OrderRepository repository;
	
	public DomainOrderService(OrderRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Order> findOrdersByReservationId(ReservationId reservationId) {
	   return repository.findOrdersByReservationId(reservationId);
	}

	@Override
	public int createOrder(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

}
