package com.csbalkan.webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Product;

public interface ProductReposiotry extends JpaRepository<Product, Integer>{

}
