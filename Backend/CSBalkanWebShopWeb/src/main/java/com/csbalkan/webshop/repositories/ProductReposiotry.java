package com.csbalkan.webshop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Product;

public interface ProductReposiotry extends JpaRepository<Product, Integer>{

	public Optional<Product> findByName(String name);

}
