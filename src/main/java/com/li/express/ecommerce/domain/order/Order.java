package com.li.express.ecommerce.domain.order;

import java.util.List;

import com.li.express.ecommerce.domain.ReservationId;
import com.li.express.ecommerce.domain.product.ProductId;
import com.li.express.ecommerce.domain.product.ProductOrderField;

public class Order {
	
	private ProductId productId;
	private List<ProductOrderField> configFields;
	private OrderId orderId;
	private ReservationId reservationId;
	
	public Order(OrderId orderId,ReservationId reservationId, ProductId productId ) {
		this.orderId = orderId;
		this.reservationId = reservationId;
		this.productId = productId;
	}
	
	
	public void addConfigFields(List<ProductOrderField> configFields) {
		this.configFields = configFields;
	}
	
	public List<ProductOrderField> getConfigFields(){
		return this.configFields;
	}
	
	public ProductId getProductId() {
		return productId;
	}

	public OrderId getOrderId() {
		return orderId;
	}

	public ReservationId getReservationId() {
		return reservationId;
	}
	
	
	
	
}
