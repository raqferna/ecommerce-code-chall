package com.li.express.ecommerce.application.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.li.express.ecommerce.application.product.ApplicationProductService;
import com.li.express.ecommerce.application.product.CreateProductRequest;
import com.li.express.ecommerce.domain.product.Product;
import com.li.express.ecommerce.domain.product.ProductId;
import com.li.express.ecommerce.domain.product.ProductRepository;
import com.li.express.ecommerce.domain.service.ProductService;
public class ApplicationProductServiceTest {
	
	private ApplicationProductService sut;
	private ProductService service;
	private ProductRepository repository;

	
	
	@BeforeEach
	void setUp() {
		repository = Mockito.mock(ProductRepository.class);
		service = Mockito.mock(ProductService.class);
		sut = new ApplicationProductService(repository,service);
	}	
	
   @Test
   void createProduct_whenProductIsValid_saveOK() {
	    CreateProductRequest prod = CreateProductRequestMother.CreateRandomProductRequest();
	    ArgumentCaptor<Product> productCaptor = ArgumentCaptor.forClass(Product.class);
	    sut.createProduct(prod);
	    when(repository.nextProductId()).thenReturn(new ProductId(1));
	    Mockito.verify(this.service, times(1)).createProduct(productCaptor.capture());

	}
	
   //TODO
	void createProduct_whenProductIsInvalid_throwsException() {
		
	}


}
