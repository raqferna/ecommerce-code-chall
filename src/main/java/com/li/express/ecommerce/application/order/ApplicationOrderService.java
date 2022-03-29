package com.li.express.ecommerce.application.order;

import org.springframework.stereotype.Service;

import com.li.express.ecommerce.domain.ReservationId;
import com.li.express.ecommerce.domain.order.Order;
import com.li.express.ecommerce.domain.order.OrderRepository;
import com.li.express.ecommerce.domain.product.ProductId;
import com.li.express.ecommerce.domain.service.OrderService;

@Service
public class ApplicationOrderService {
	
	private OrderRepository repository;
	private OrderService orderService;
	
	public ApplicationOrderService(OrderRepository repository, OrderService orderService) {
		this.repository = repository;
		this.orderService = orderService;
	}
	
	public int createOrder(CreateOrderRequest order) {
     return	orderService.createOrder(getOrderFromRequest(order));
	}
	
	private Order getOrderFromRequest(CreateOrderRequest order) {
		return new Order(repository.nextOrderId(),
				new ReservationId(Integer.valueOf(order.getReservationId())), 
						new ProductId(Integer.valueOf(order.getProductId())));
	}

}
