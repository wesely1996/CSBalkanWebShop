package com.csbalkan.webshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	@Query("select c from Cart c where c.user.username=:user")
	public List<Cart> findByUsername(@Param("user") String username);

}
