package com.csbalkan.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.csbalkan.webshop.dto.NewProductDTO;
import com.csbalkan.webshop.repositories.ProductReposiotry;

import model.Product;

@Service
public class AdminService {
	
	@Autowired
	ProductReposiotry pr;
	
	public ResponseEntity<?> addProduct(NewProductDTO product){
		if(pr.findByName(product.getName()).isPresent())
			return ResponseEntity.badRequest().body("Product with this name already exists.");
		Product newProduct = new Product();
		newProduct.setDescription(product.getDescription());
		newProduct.setImage(product.getImage());
		newProduct.setName(product.getName());
		newProduct.setPrice(product.getPrice());
		newProduct.setQuantity(product.getQuantity());
		newProduct.setType(product.getType());
		newProduct = pr.save(newProduct);
		if(newProduct == null)
			return ResponseEntity.badRequest().body("We have failed to add new product.");
		return ResponseEntity.ok("New product has been created.");
	}
	
	public ResponseEntity<?> changeAmountOfProduct(String name, int amount){
		if(pr.findByName(name).isEmpty())
			return ResponseEntity.badRequest().body("Product doesn't exists.");
		Product p = pr.findByName(name).get();
		p.setQuantity(p.getQuantity() + amount);
		Product newP = pr.save(p);
		if(newP.getQuantity() == p.getQuantity())
			return ResponseEntity.ok("Product doesn't exists.");
		return ResponseEntity.badRequest().body("Failed to change the amount of product.");
	}
	
	public ResponseEntity<?> deleteProduct(String name){
		if(pr.findByName(name).isEmpty())
			return ResponseEntity.badRequest().body("Product doesn't exists.");
		pr.deleteById(pr.findByName(name).get().getId());
		return ResponseEntity.ok("Product has been deleted.");
	}
}
