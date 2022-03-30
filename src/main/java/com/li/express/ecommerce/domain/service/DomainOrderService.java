package com.li.express.ecommerce.domain.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public int createOrder(Order order) {
		validateOrder(order);
		repository.createOrder(order);
		return order.getOrderId().value();
	}
	
	private void validateOrder(Order order) {
		validateReservationId(order.getReservationId());
		validateProductId(order.getProductId());
	}
	
	private void validateReservationId(ReservationId reservationId) {
		//TODO validation if exists
		if(reservationId == null) {
			throw new IllegalArgumentException("ReservationId must not be null");
		}
	}
	
	private void validateProductId(ProductId productId) {
		//TODO validation if exists
		if(productId == null) {
			throw new IllegalArgumentException("ProductId must not be null");
		}

	}

}
