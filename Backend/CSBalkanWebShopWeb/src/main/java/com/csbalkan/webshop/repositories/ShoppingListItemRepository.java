package com.csbalkan.webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Shoppinglistitem;

public interface ShoppingListItemRepository extends JpaRepository<Shoppinglistitem, Integer>{

}
