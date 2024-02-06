package com.csbalkan.webshop.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.csbalkan.webshop.dto.CartDTO;
import com.csbalkan.webshop.dto.CartProductsDTO;
import com.csbalkan.webshop.dto.FavoriteDTO;
import com.csbalkan.webshop.dto.ProductDTO;
import com.csbalkan.webshop.repositories.CartRepository;
import com.csbalkan.webshop.repositories.FavoriteProductRepository;
import com.csbalkan.webshop.repositories.ProductReposiotry;
import com.csbalkan.webshop.repositories.ShoppingListItemRepository;
import com.csbalkan.webshop.repositories.ShoppingListRepository;
import com.csbalkan.webshop.repositories.UserRepository;

import model.Favoriteproduct;
import model.Cart;
import model.Product;
import model.Shoppinglist;
import model.Shoppinglistitem;

@Service
public class ProductsService {

	@Autowired
	ProductReposiotry pr;
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	FavoriteProductRepository fpr;
	
	@Autowired
	CartRepository cr;
	
	@Autowired
	ShoppingListItemRepository slir;
	
	@Autowired
	ShoppingListRepository slr;
	
	public List<ProductDTO> getAllProducts(){
		List<Product> products = pr.findAll();
		List<ProductDTO> productsDTO = new ArrayList<ProductDTO>();
		for(Product p: products) {
			ProductDTO pdto = new ProductDTO();
			BeanUtils.copyProperties(p, pdto);
			pdto.setIdProducts(p.getId());
			productsDTO.add(pdto);
		}
		return productsDTO;
	}
	
	public ResponseEntity<?> addFavoriteProduct(FavoriteDTO fav){
		if(pr.findById(fav.getProduct()).isEmpty())
			return ResponseEntity.badRequest().body("This product doesn't exist.");
		if(ur.findByUsername(fav.getUser())==null)
			return ResponseEntity.badRequest().body("User doesn't exist.");
		Favoriteproduct fp = new Favoriteproduct();
		fp.setProduct(pr.findById(fav.getProduct()).get());
		fp.setUser(ur.findByUsername(fav.getUser()));
		fp = fpr.save(fp);
		if(fp == null)
			return ResponseEntity.badRequest().body("Failed to save favorite product.");
		return ResponseEntity.ok("Product has been added to favorites");
	}
	
	public ResponseEntity<?> getUserFavorites(String username){
		if(ur.findByUsername(username)==null)
			return ResponseEntity.badRequest().body("This user doesn't exist.");
		List<Favoriteproduct> fplist = fpr.findByUsername(username);
		List<ProductDTO> favproducts = new ArrayList<ProductDTO>();
		for(Favoriteproduct fp: fplist) {
			ProductDTO p = new ProductDTO();
			p.setDescription(fp.getProduct().getDescription());
			p.setName(fp.getProduct().getName());
			p.setIdProducts(fp.getProduct().getId());
			p.setImage(fp.getProduct().getImage());
			p.setPrice(fp.getProduct().getPrice());
			p.setType(fp.getProduct().getType());
			favproducts.add(p);
		}
		return ResponseEntity.ok(favproducts);
	}
	
	public ResponseEntity<?> addToCart(CartDTO cartItem){
		if(pr.findById(cartItem.getProduct()).isEmpty())
			return ResponseEntity.badRequest().body("Product "+cartItem.getProduct()+" doesn't exist.");
		if(ur.findByUsername(cartItem.getUser())==null)
			return ResponseEntity.badRequest().body("User "+cartItem.getUser()+" doesn't exist.");
		List<Cart> cart = cr.findByUsername(cartItem.getUser());
		Cart newItem = null;
		if(cart != null) {
			for(Cart c: cart) {
				if(c.getProduct().getId() == cartItem.getProduct()) {
					newItem = c;
					break;
				}
			}
		}
		if(newItem == null) {
			newItem = new Cart();
			newItem.setProduct(pr.findById(cartItem.getProduct()).get());
			newItem.setUser(ur.findByUsername(cartItem.getUser()));
			newItem.setAmount(cartItem.getAmount());
		}else {
			newItem.setAmount(newItem.getAmount() + cartItem.getAmount());
		}
		newItem = cr.save(newItem);
		if(newItem==null)
			return ResponseEntity.badRequest().body("Failed to save cart product.");
		return ResponseEntity.ok("Product has been added to cart.");
	}
	
	public ResponseEntity<?> removeFromCart(CartDTO cartItem){
		if(pr.findById(cartItem.getProduct()).isEmpty())
			return ResponseEntity.badRequest().body("This product doesn't exist.");
		if(ur.findByUsername(cartItem.getUser())==null)
			return ResponseEntity.badRequest().body("User doesn't exist.");
		List<Cart> cart = cr.findByUsername(cartItem.getUser());
		Cart newItem = null;
		if(cart != null) {
			for(Cart c: cart) {
				if(c.getProduct().getId() == cartItem.getProduct()) {
					newItem = c;
					break;
				}
			}
		}
		if(newItem == null) {
			return ResponseEntity.ok("Cart is empty.");
		}else {
			newItem.setAmount(cartItem.getAmount());
		}
		if(newItem.getAmount()<=0) {
			cr.deleteById(newItem.getId());
			return ResponseEntity.ok("Product has been deleted from the cart.");
		}
		else
			newItem = cr.save(newItem);
		if(newItem==null)
			return ResponseEntity.badRequest().body("Failed to save cart product.");
		return ResponseEntity.ok("Product has been removed from the cart");
	}
	
	public ResponseEntity<?> getCartItems(String username){
		if(ur.findByUsername(username)==null)
			return ResponseEntity.badRequest().body("This user doesn't exist.");
		List<Cart> cart = cr.findByUsername(username);
		List<CartProductsDTO> products = new ArrayList<CartProductsDTO>();
		for(Cart c: cart) {
			CartProductsDTO p = new CartProductsDTO();
			p.setAmount(c.getAmount());
			p.setId(c.getProduct().getId());
			p.setName(c.getProduct().getName());
			p.setPrice(c.getProduct().getPrice());
			products.add(p);
		}
		return ResponseEntity.ok(products);
	}
	
	public ResponseEntity<?> buy(String user){
		if(ur.findByUsername(user)==null)
			return ResponseEntity.badRequest().body("User doesn't exist.");
		List<Cart> cart = cr.findByUsername(user);
		if(cart == null)
			return ResponseEntity.badRequest().body("Cart is empty.");
		Shoppinglist shoppinglist = new Shoppinglist();
		shoppinglist.setTimestamp(Calendar.getInstance().getTime());
		shoppinglist.setUser(ur.findByUsername(user));
		shoppinglist = slr.save(shoppinglist);
		if(shoppinglist == null)
			return ResponseEntity.badRequest().body("Error creating shopping list.");
		for(Cart c: cart) {
			Shoppinglistitem newItem = new Shoppinglistitem();
			newItem.setPrice(c.getProduct().getPrice().doubleValue());
			newItem.setProduct(c.getProduct());
			newItem.setQuantity(c.getAmount());
			
			Product p = pr.findById(newItem.getProduct().getId()).get();
			if(p.getQuantity() < newItem.getQuantity())
				newItem.setQuantity(p.getQuantity());
			p.setQuantity(p.getQuantity() - newItem.getQuantity());
			pr.save(p);
			
			newItem.setShoppinglist(shoppinglist);
			slir.save(newItem);
			
			cr.deleteById(c.getId());
		}
		return ResponseEntity.ok("Cart has been baught successfuly.");
	}
	
	public ResponseEntity<?> history(String user){
		if(ur.findByUsername(user)==null)
			return ResponseEntity.badRequest().body("User doesn't exist.");
		List<Shoppinglist> shoppinglist = slr.findByUsername(user);
		return ResponseEntity.ok(shoppinglist);
	}

	public ResponseEntity<?> removeFromFav(CartDTO cartItem) {
		if(ur.findByUsername(cartItem.getUser())==null)
			return ResponseEntity.badRequest().body("User doesn't exist.");
		if(pr.findById(cartItem.getProduct()).isEmpty())
			return ResponseEntity.badRequest().body("Product doesn't exist.");
		Favoriteproduct fp = fpr.findByUsernameProduct(cartItem.getUser(), cartItem.getProduct());
		if(fp == null)
			return ResponseEntity.badRequest().body("Product isn't a favortie.");
		fpr.deleteById(fp.getId());
		return ResponseEntity.ok("Fav has been deleted.");
	}
}
