package com.li.express.ecommerce.domain.service;

import java.util.List;

import com.li.express.ecommerce.domain.ReservationId;
import com.li.express.ecommerce.domain.order.Order;
import com.li.express.ecommerce.domain.order.OrderRepository;
import com.li.express.ecommerce.domain.product.ProductId;


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
		if(validateReservationId(order.getReservationId()) && validateProductId(order.getProductId())) {
			repository.createOrder(order);
		}
		return order.getOrderId().value();
	}
	
	
	private boolean validateReservationId(ReservationId reservationId) {
		//TODO 
		return true;
	}
	

	private boolean validateProductId(ProductId reservationId) {
		//TODO 
		return true;
	}

}
