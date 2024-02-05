package com.csbalkan.webshop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUsername(String username);

	public Optional<User> findByUsernameIgnoreCase(String username);
	
	public Optional<User> findByEmailIgnoreCase(String email);
}
