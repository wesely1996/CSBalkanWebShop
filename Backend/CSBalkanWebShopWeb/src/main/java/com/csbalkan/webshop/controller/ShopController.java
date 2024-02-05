package com.csbalkan.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csbalkan.webshop.dto.CartDTO;
import com.csbalkan.webshop.dto.FavoriteDTO;
import com.csbalkan.webshop.dto.StringDTO;
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
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addFavorite")
	public ResponseEntity<?> getUserFavList(@RequestBody FavoriteDTO fav){
		return ps.addFavoriteProduct(fav);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/favorites/{user}")
	public ResponseEntity<?> getUserFavList(@PathVariable String user){
		return ps.getUserFavorites(user);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addToCart")
	public ResponseEntity<?> addToCart(@RequestBody CartDTO cartItem){
		return ResponseEntity.ok(ps.addToCart(cartItem));
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/cart/{user}")
	public ResponseEntity<?> getCart(@PathVariable String user){
		return ps.getCartItems(user);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/removeFromCart")
	public ResponseEntity<?> removeFromCart(@RequestBody CartDTO cartItem){
		return ResponseEntity.ok(ps.removeFromCart(cartItem));
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/buy")
	public ResponseEntity<?> buy(@RequestBody StringDTO user){
		return ps.buy(user.getValue());
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/shoppingHistory")
	public ResponseEntity<?> history(@RequestBody StringDTO user){
		return ps.history(user.getValue());
	}
}
