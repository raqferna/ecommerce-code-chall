package com.li.express.ecommerce.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.li.express.ecommerce.LibereEcommerceChallengeApplication;
import com.li.express.ecommerce.domain.order.OrderRepository;
import com.li.express.ecommerce.domain.product.ProductRepository;
import com.li.express.ecommerce.domain.service.DomainOrderService;
import com.li.express.ecommerce.domain.service.DomainProductService;
import com.li.express.ecommerce.domain.service.OrderService;
import com.li.express.ecommerce.domain.service.ProductService;

@Configuration
@ComponentScan(basePackageClasses = LibereEcommerceChallengeApplication.class)
public class BeanConfiguration {

	    @Bean
	    OrderService orderService(final OrderRepository orderRepository) {
	        return new DomainOrderService(orderRepository);
	    }
	
	    
	    @Bean
	    ProductService productService(final ProductRepository productRepo) {
	        return new DomainProductService(productRepo);
	    }
	

	    

}
