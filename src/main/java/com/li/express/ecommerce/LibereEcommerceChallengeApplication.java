package com.li.express.ecommerce;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;




@SpringBootApplication
@EnableWebMvc
public class LibereEcommerceChallengeApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(LibereEcommerceChallengeApplication.class, args);
		
	}
	
	
//TODO SWAGGER OPENAPI CONFIG	
//	  @Bean
//	  public OpenAPI springShopOpenAPI() {
//	      return new OpenAPI()
//	              .info(new Info().title("SpringShop API")
//	              .description("Spring shop sample application")
//	              .version("v0.0.1")
//	              .license(new License().name("Apache 2.0").url("http://springdoc.org")))
//	              .externalDocs(new ExternalDocumentation()
//	              .description("SpringShop Wiki Documentation")
//	              .url("https://springshop.wiki.github.org/docs"));
//	  }
}
