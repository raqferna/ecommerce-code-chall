package com.li.express.ecommerce.domain.product;

import com.li.express.ecommerce.domain.service.ProductMother;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ProductTest {
	
	
	@Test
	void create_createStatus_createActive() {
		Product sut = ProductMother.getRandomProduct();
		assertEquals(ProductStatus.ACTIVE, sut.getProductStatus());
	}
	@Test
	void isActive_whenIsActive_returnTrue(){
		Product sut = ProductMother.getRandomProduct();
		assertTrue(sut.isActive());
	}
	
	@Test
	void isActive_whenIsActive_returnFalse(){
		Product sut = ProductMother.getRandomProduct();
		sut.inactiveProduct();
		assertFalse(sut.isActive());
	}
	
	@Test
	void inactive_whenReturnStatus_returnInactive(){
		Product sut = ProductMother.getRandomProduct();
		sut.inactiveProduct();
		assertEquals(ProductStatus.INACTIVE, sut.getProductStatus());
		
	}
	
	@Test
	void active_whenReturnStatus_returnActive(){
		Product sut = ProductMother.getRandomProduct();
		sut.inactiveProduct();
		sut.activeProduct();
		assertEquals(ProductStatus.ACTIVE, sut.getProductStatus());
	}
	  
	  
	  


}
