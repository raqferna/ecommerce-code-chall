package com.li.express.ecommerce.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
	
	void addProduct(Product newProduct);
	
	Optional<Product> findProduct(ProductId productId);
	
	List<Product> findProductsActive();
	
	ProductId nextProductId();
	


}
