package com.li.express.ecommerce.domain.service;

import java.util.List;
import java.util.Optional;

import com.li.express.ecommerce.domain.product.Product;
import com.li.express.ecommerce.domain.product.ProductId;
import com.li.express.ecommerce.domain.product.ProductRepository;



public class DomainProductService implements ProductService{
	
	
	private final ProductRepository repository;
	
	
	public DomainProductService(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public void createProduct(Product product) {
		repository.addProduct(product);
	}


	@Override
	public Optional<Product> getProductDescription(ProductId id) {
		return repository.findProduct(id);
	}

	@Override
	public List<Product> getActiveProducts() {
		return  repository.findProductsActive();
	}


}
