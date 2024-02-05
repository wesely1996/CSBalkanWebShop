package com.csbalkan.webshop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	public Optional<Role> findByName(String name);
}
