package com.li.express.ecommerce.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.li.express.ecommerce.domain.product.Product;
import com.li.express.ecommerce.domain.product.ProductId;
import com.li.express.ecommerce.domain.product.ProductRepository;

public class ProductServiceTest {
	
	
	private DomainProductService sut;
	private ProductRepository repository;
	private OrderService service;
	
	@BeforeEach
	void setUp() {
        service = Mockito.mock(OrderService.class);
        repository = Mockito.mock(ProductRepository.class);
		sut = new DomainProductService(repository, service);
	}
	
	@Test
	void getProduct_whenProductExists_returnProduct(){
		Optional<Product> optProduct = Optional.of(ProductMother.getRandomProduct());
		when(repository.findProduct(new ProductId(1))).thenReturn(optProduct);
		assertEquals(optProduct.get(), sut.getProduct(new ProductId(1)).get());
	}
	
	@Test
	void createProduct_whenProductIsValid_saveOk(){
		Product prod = ProductMother.getRandomProduct();
		sut.createProduct(prod);
	    Mockito.verify(this.repository, times(1)).addProduct(prod);
    }
		
	
	//TODO
	void createProduct_whenProductIsNotValid_throwsException(){
	
	}
	

	//TODO
	void getProduct_whenProductNotExists_returnEmpty(){
	
	}
	
	//TODO
	void getProductsOrderByRelevance_whenReservationExists_orderAndFilter() {
		//TODO TESTING FILTER AND SORTING
	}
	

}
