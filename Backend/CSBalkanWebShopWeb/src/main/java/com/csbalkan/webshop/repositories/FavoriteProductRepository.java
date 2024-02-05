package com.csbalkan.webshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Favoriteproduct;

public interface FavoriteProductRepository extends JpaRepository<Favoriteproduct, Integer>{

	@Query("select fp from Favoriteproduct fp where fp.user.username=:user")
	public List<Favoriteproduct> findByUsername(@Param("user") String username);

}
