package com.csbalkan.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csbalkan.webshop.dto.NewProductDTO;
import com.csbalkan.webshop.dto.StringDTO;
import com.csbalkan.webshop.service.AdminService;

@RestController
@RequestMapping("/adm")
public class AdminController {

	@Autowired
	AdminService as;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addProduct")
	public ResponseEntity<?> addProduct(@RequestBody NewProductDTO product){
		return as.addProduct(product);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/removeProduct")
	public ResponseEntity<?> removeProduct(@RequestBody StringDTO product){
		return as.deleteProduct(product.getValue());
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/changeProductAmount")
	public ResponseEntity<?> changeProductAmount(@RequestBody NewProductDTO product){
		return as.changeAmountOfProduct(product.getName(), product.getQuantity());
	}
}
