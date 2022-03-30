package com.li.express.ecommerce.domain.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import com.li.express.ecommerce.domain.ReservationId;
import com.li.express.ecommerce.domain.order.Order;
import com.li.express.ecommerce.domain.product.Product;
import com.li.express.ecommerce.domain.product.ProductId;
import com.li.express.ecommerce.domain.product.ProductRepository;


public class DomainProductService implements ProductService{
	
	
	private final ProductRepository repository;
	private final OrderService orderService;
	
	public DomainProductService(ProductRepository repository,  OrderService orderService) {
		this.repository = repository;
		this.orderService = orderService;
	}

	@Override
	@Transactional
	public void createProduct(Product product) {
		//TODO VALIDATE 
		repository.addProduct(product);
	}
	
 

	@Override
	public Optional<Product> getProduct(ProductId id) {
		return repository.findProduct(id);
	}

	@Override
	public List<Product> getProductsOrderByRelevance(ReservationId reservationId) {
		List<Product> activeProducts = repository.findProductsActive();
		List<Order> ordersList = orderService.findOrdersByReservationId(reservationId);
		return filterAndSortProducts(ordersList, activeProducts);
		
	}
	
	private List<Product>  filterAndSortProducts(List<Order> ordersList, List<Product> activeProducts  ) {
		Map<ProductId, Long> productsMap = ordersList.stream().collect(Collectors.groupingBy(Order::getProductId, Collectors.counting()));
		List<Product> productsFiltered = filter(activeProducts, productsMap);
		sort(productsMap, productsFiltered);
		return productsFiltered;
		
	}

	private List<Product> filter(List<Product> activeProducts, Map<ProductId, Long> productsMap) {
		List<Product> productsFiltered = activeProducts.stream().filter(product -> productsMap.containsKey(product.getProductId()))
				.collect(Collectors.toList());
		return productsFiltered;
	}

	private void sort(Map<ProductId, Long> productsMap, List<Product> productsFiltered) {
		productsFiltered.sort(Comparator.comparing(Product::getDateCreated)
				.thenComparingLong(p ->productsMap.get(p.getProductId())).reversed());
	}
	




}
