package com.csbalkan.webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Shoppinglist;

public interface ShoppingListRepository extends JpaRepository<Shoppinglist, Integer>{

}
