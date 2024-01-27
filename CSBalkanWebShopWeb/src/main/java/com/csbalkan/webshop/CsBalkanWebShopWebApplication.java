package com.csbalkan.webshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("model")
public class CsBalkanWebShopWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsBalkanWebShopWebApplication.class, args);
	}

}
