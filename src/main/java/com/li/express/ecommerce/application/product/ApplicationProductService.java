package com.li.express.ecommerce.application.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.li.express.ecommerce.domain.ReservationId;
import com.li.express.ecommerce.domain.product.Product;
import com.li.express.ecommerce.domain.product.ProductDescription;
import com.li.express.ecommerce.domain.product.ProductId;
import com.li.express.ecommerce.domain.product.ProductRepository;
import com.li.express.ecommerce.domain.service.ProductService;

@Service
public class ApplicationProductService {
	
	private ProductRepository repository;
	private ProductService productService;

	public ApplicationProductService(ProductRepository repository, 
			 ProductService productService) {
		this.repository = repository;
		this.productService = productService;
	}
	
	public void createProduct(CreateProductRequest request) {

			Product pro = new Product
					     .ProductBuilder(repository.nextProductId())
			             .productPrice(Long.valueOf(request.getPrice()))
			             .productDescription(new ProductDescription(request.getDescription()))
			             .productName(request.getName())
				         .productOrderFields(request.getProductOrderFields())
				         .build();
			
			productService.createProduct(pro);
	}

	public List<Product> getProductsByReservationId(int reservationId) {
		return productService.getProductsOrderByRelevance(new ReservationId(reservationId));
	}
	
	public ProductDetailReponse getProductDetail(int productId) {
		Optional<Product> product = productService.getProduct(new ProductId(productId));
		if(product.isPresent()) {
			return ProductDetailReponse.fromProduct(product.get());
		}
		return new ProductDetailReponse();
	}
	
}


