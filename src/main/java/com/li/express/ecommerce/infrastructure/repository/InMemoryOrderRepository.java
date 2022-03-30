package com.li.express.ecommerce.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.li.express.ecommerce.domain.ReservationId;
import com.li.express.ecommerce.domain.order.Order;
import com.li.express.ecommerce.domain.order.OrderId;
import com.li.express.ecommerce.domain.order.OrderRepository;
import com.li.express.ecommerce.domain.product.ProductId;

@Repository
@Primary
public class InMemoryOrderRepository implements OrderRepository{
	
	List<Order> orders = new ArrayList<>();
	
	@Autowired
	public InMemoryOrderRepository() {
		populateOrders();
	}
	

	@Override
	public List<Order> findOrdersByReservationId(ReservationId id) {
		return orders.stream().filter( order -> order.getReservationId().equals(id)).collect(Collectors.toList());
	}

	@Override
	public int createOrder(Order order) {
		orders.add(order);
	    return order.getOrderId().value();
	}

	@Override
	public OrderId nextOrderId() {
		return new OrderId(orders.size() + 1);
	}
	
	// FAKE orders
			private void populateOrders() {
				orders.add(getSampleOrder(1,2));
				orders.add(getSampleOrder(1,3));
				orders.add(getSampleOrder(1,2));
				orders.add(getSampleOrder(2,2));
		

			}
			
			private Order getSampleOrder(int reservationId, int productId) {
				
				return new Order(new OrderId(orders.size()+1), new ReservationId(reservationId),
						new ProductId(productId));
			}


	

}
