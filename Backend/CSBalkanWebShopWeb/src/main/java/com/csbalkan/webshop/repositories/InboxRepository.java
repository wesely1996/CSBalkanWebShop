package com.csbalkan.webshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Inbox;

public interface InboxRepository extends JpaRepository<Inbox, Integer> {

	@Query("select i from Inbox i where i.user1.username=:user or i.user2.username=:user")
	public List<Inbox> findByUsername(@Param("user") String username);

}
