package com.li.express.ecommerce.infrastructure.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.li.express.ecommerce.domain.Product;
import com.li.express.ecommerce.domain.ProductDescription;
import com.li.express.ecommerce.domain.ProductId;
import com.li.express.ecommerce.domain.ProductOrderField;
import com.li.express.ecommerce.domain.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository{
	
	List<Product> products = new ArrayList<Product>();

	public InMemoryProductRepository() {
		populateProducts();
	}

	@Override
	public void addProduct(Product newProduct) {
		products.add(newProduct);
		
	}

	@Override
	public Optional<Product> findProduct(ProductId productId) {
		return products.stream().filter(product -> product.getProductId().equals(productId)).findFirst();
	}

	@Override
	public List<Product> findProductsActive() {
		return products.stream().filter(Product::isActive).collect(Collectors.toList());
	}
	
	private void populateProducts() {
		products.add(getSampleProduct("Prod1", "desc1", 1));
		products.add(getSampleProduct("Prod2", "desc2", 1));
		products.add(getSampleProduct("Prod3", "desc3", 1));
		products.add(getSampleProduct("Prod4", "desc4", 1));

	}
	
	private Product getSampleProduct(String name, String descProd, double price) {
		String productName =name;
		ProductDescription desc= new  ProductDescription(descProd);
		ProductOrderField orderField = new ProductOrderField("name "+name, "type "+descProd);
		ProductId id = new ProductId(products.size());
		return new Product(id, productName, desc, price,Arrays.asList(orderField));
	}

}
