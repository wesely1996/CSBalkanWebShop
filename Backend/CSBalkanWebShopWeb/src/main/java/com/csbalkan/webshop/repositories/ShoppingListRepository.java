package com.csbalkan.webshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Shoppinglist;

public interface ShoppingListRepository extends JpaRepository<Shoppinglist, Integer>{

	@Query("select sl from Shoppinglist sl where sl.user.username=:user")
	public List<Shoppinglist> findByUsername(@Param("user") String user);

}
