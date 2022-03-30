package com.li.express.ecommerce.application.rest.order;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.li.express.ecommerce.application.order.ApplicationOrderService;
import com.li.express.ecommerce.application.order.CreateOrderRequest;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
    private  ApplicationOrderService orderService;
   

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "getProduct", description = "Create new order and return de id")   
    int createOrder(@RequestBody final CreateOrderRequest createOrderRequest) throws IOException, JsonMappingException, JsonProcessingException {
    	return orderService.createOrder(createOrderRequest);
      
    }


}
