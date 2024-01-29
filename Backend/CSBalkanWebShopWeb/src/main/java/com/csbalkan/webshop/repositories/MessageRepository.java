package com.csbalkan.webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
