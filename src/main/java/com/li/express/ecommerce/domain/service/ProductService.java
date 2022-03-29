package com.li.express.ecommerce.domain.service;

import java.util.List;
import java.util.Optional;

import com.li.express.ecommerce.domain.Product;
import com.li.express.ecommerce.domain.ProductId;



public interface ProductService {
    
	void createProduct(Product product);
	
	List<Product> getActiveProducts();
	
	Optional<Product> getProductDescription(ProductId id);
	
}
