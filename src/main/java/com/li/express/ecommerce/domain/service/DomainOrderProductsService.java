package com.li.express.ecommerce.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.li.express.ecommerce.domain.ReservationId;
import com.li.express.ecommerce.domain.order.Order;
import com.li.express.ecommerce.domain.product.Product;



public class DomainOrderProductsService{
	
	private final OrderService orderService;
	private final ProductService productService;
	
	public DomainOrderProductsService(OrderService orderService, ProductService productService) {
		this.orderService = orderService;
		this.productService = productService;
	}
	
	
	List<Product> getProductsSortByRelevance(ReservationId reservationId){
		List<Order> orderList = orderService.findOrdersByReservationId(reservationId);
		List<Product> productList = productService.getActiveProducts();
		return filteredProductList(productList, orderList);
	}


	private List<Product> filteredProductList(List<Product> productList, List<Order> orderList) {
	//TODO
       return new ArrayList<Product>();
	   
	}

//	public List<OrderProducts> getOrdereredProductsList(){
//		//List<Order> orderList = orderService.getAllOrders();
//		List<Product> productList = productService.getActiveProducts();
//	}

}
