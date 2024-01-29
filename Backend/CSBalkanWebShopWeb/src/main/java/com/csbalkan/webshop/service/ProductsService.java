package com.csbalkan.webshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csbalkan.webshop.dto.CartDTO;
import com.csbalkan.webshop.dto.ProductDTO;
import com.csbalkan.webshop.repositories.ProductReposiotry;

import model.Product;

@Service
public class ProductsService {

	@Autowired
	ProductReposiotry pr;
	
	public List<ProductDTO> getAllProducts(){
		List<Product> products = pr.findAll();
		List<ProductDTO> productsDTO = new ArrayList<ProductDTO>();
		for(Product p: products) {
			ProductDTO pdto = new ProductDTO();
			BeanUtils.copyProperties(p, pdto);
			productsDTO.add(pdto);
		}
		return productsDTO;
	}
	
	public List<CartDTO> addItemToCart(CartDTO cartItem){
		return null;
	}
}
