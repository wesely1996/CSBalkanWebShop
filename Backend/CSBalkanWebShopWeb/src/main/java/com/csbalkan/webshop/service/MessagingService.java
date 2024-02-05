package com.csbalkan.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.csbalkan.webshop.dto.InboxDTO;
import com.csbalkan.webshop.repositories.InboxRepository;
import com.csbalkan.webshop.repositories.UserRepository;

import model.Inbox;

@Service
public class MessagingService {

	@Autowired
	InboxRepository ir;
	
	@Autowired
	UserRepository ur;
	
	public ResponseEntity<?> sendMessage(InboxDTO msg){
		if(ur.findByUsername(msg.getSender())==null)
			return ResponseEntity.badRequest().body("User " + msg.getSender() + " doesn't exist.");
		if(ur.findByUsername(msg.getReciver())==null)
			return ResponseEntity.badRequest().body("User " + msg.getReciver() + " doesn't exist.");
		Inbox message = new Inbox();
		message.setMessage(msg.getMessage());
		message.setSubject(msg.getSubject());
		message.setTimestamp(msg.getTimestamp());
		message.setUser1(ur.findByUsername(msg.getSender()));
		message.setUser2(ur.findByUsername(msg.getReciver()));
		message = ir.save(message);
		if(message == null)
			return ResponseEntity.badRequest().body("Failed to send message.");
		return ResponseEntity.ok("Message Successfuly sent.");
	}
	
	public ResponseEntity<?> getAllMessages(String username){
		if(ur.findByUsername(username)==null)
			return ResponseEntity.badRequest().body("User " + username + " doesn't exist.");
		return ResponseEntity.ok(ir.findByUsername(username));
	}
}
