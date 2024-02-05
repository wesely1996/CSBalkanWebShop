package com.csbalkan.webshop.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csbalkan.webshop.dto.InboxDTO;
import com.csbalkan.webshop.service.MessagingService;

@Controller
@RequestMapping("/msg")
public class MessagingController {
	
	@Autowired
	MessagingService ms;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/send")
	public ResponseEntity<?> sendMessage(@RequestBody InboxDTO msg){
		msg.setTimestamp(Calendar.getInstance().getTime());
		return ms.sendMessage(msg);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getAll/{username}")
	public ResponseEntity<?> sendMessage(@PathVariable String username){
		return ResponseEntity.ok(ms.getAllMessages(username));
	}
}
