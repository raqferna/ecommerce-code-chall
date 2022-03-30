package com.li.express.ecommerce.domain.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ProductOrderFieldTest {
	

	@Test
	void create_whenNameIsNull_throwsException(){
    	assertThrows(IllegalArgumentException.class, ()->new ProductOrderField(null, ""));
	
	}
	@Test
	void create_whenTypeIsNull_throwsException(){
		assertThrows(IllegalArgumentException.class, ()->new ProductOrderField("", null));
	}
	@Test
	void create_paramsOK_getCorrectParams(){
		ProductOrderField orderF = new ProductOrderField("order","field");
		assertEquals("order", orderF.getName());
		assertEquals("field", orderF.getType());
	}
}
