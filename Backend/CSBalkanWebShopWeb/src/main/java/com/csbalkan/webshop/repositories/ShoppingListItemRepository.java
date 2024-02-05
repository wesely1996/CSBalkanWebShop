package com.csbalkan.webshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Shoppinglistitem;

public interface ShoppingListItemRepository extends JpaRepository<Shoppinglistitem, Integer>{

	@Query("select sli from Shoppinglistitem sli where sli.shoppinglist.user.username=:user")
	public List<Shoppinglistitem> findByUsername(@Param("user") String username);
}
