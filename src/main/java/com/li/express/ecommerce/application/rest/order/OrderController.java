package com.li.express.ecommerce.application.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.li.express.ecommerce.domain.Order;
import com.li.express.ecommerce.domain.service.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
    private  OrderService orderService;

   

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    int createOrder(@RequestBody final String createOrderRequest) throws IOException, JsonMappingException, JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();
        final int id = orderService.createOrder( mapper.readValue(createOrderRequest, Order.class)	);
        return id;
    }


}
