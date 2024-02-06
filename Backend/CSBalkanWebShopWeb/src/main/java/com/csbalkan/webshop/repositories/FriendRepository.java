package com.csbalkan.webshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Friend;

public interface FriendRepository extends JpaRepository<Friend, Integer>{
	
	@Query("select f from Friend f where f.user1.username=:user")
	public List<Friend> findFriendsForUser(@Param("user") String username);
	
	@Query("select f from Friend f where f.user1.username=:user and f.user2.username=:friend")
	public Friend findFriendsByUsernames(@Param("user")String username, @Param("friend") String friend);
}
