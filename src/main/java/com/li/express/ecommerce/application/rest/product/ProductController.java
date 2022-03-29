package com.li.express.ecommerce.application.rest.product;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.li.express.ecommerce.application.product.ApplicationProductService;
import com.li.express.ecommerce.application.product.CreateProductRequest;
import com.li.express.ecommerce.application.product.ProductsResponse;
import com.li.express.ecommerce.domain.Order;
import com.li.express.ecommerce.domain.Product;
import com.li.express.ecommerce.domain.service.OrderService;
import com.li.express.ecommerce.domain.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ApplicationProductService productService;
	
  
    @Autowired
    public ProductController(ApplicationProductService productService) {
        this.productService = productService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    void createProduct(@RequestBody final CreateProductRequest product) throws IOException, JsonMappingException, JsonProcessingException {
    	productService.createProduct(product);
    }
    

    @GetMapping
    ProductsResponse getProducts() throws IOException, JsonMappingException, JsonProcessingException {
        return new ProductsResponse(productService.getActiveProducts());
    }
    
    
    



}
