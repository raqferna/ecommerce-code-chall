package com.li.express.ecommerce.application.rest.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.li.express.ecommerce.application.product.ApplicationProductService;
import com.li.express.ecommerce.application.product.CreateProductRequest;
import com.li.express.ecommerce.application.product.ProductDetailReponse;
import com.li.express.ecommerce.application.product.ProductsResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/products")
@Tag(name = "Products API")
public class ProductController {
	
	private ApplicationProductService productService;
	
  
    @Autowired
    public ProductController(ApplicationProductService productService) {
        this.productService = productService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "createProduct", description = "create new Product")     
    void createProduct(@RequestBody final CreateProductRequest product) {
    	productService.createProduct(product);
     }
    

    @GetMapping(value="/reservation/{reservationId}")
    @Operation(summary = "getProducts by reservation", description = "get list of active products by reservationId order by relevance")   
    ProductsResponse getProducts(@PathVariable @NonNull int reservationId)  {
        return new ProductsResponse(productService.getProductsByReservationId(reservationId));
    }
    

    @GetMapping(value="/{productId}")
    @Operation(summary = "getProduct", description = "get detail of requested product")   
    ProductDetailReponse getProduct(@PathVariable @NonNull int productId) {
        return productService.getProductDetail(productId);
    }
    

}
