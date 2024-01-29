package com.csbalkan.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csbalkan.webshop.service.ProductsService;

@RestController
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	ProductsService ps;

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/products")
	public ResponseEntity<?> getAllProducts(){
		return ResponseEntity.ok(ps.getAllProducts());
	}
}
