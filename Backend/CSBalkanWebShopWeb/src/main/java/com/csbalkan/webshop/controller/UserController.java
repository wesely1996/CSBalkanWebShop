package com.csbalkan.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csbalkan.webshop.dto.FriendDTO;
import com.csbalkan.webshop.dto.LogInDTO;
import com.csbalkan.webshop.dto.UserDTO;
import com.csbalkan.webshop.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	UserService us;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/auth/registerUser")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserDTO registration) {
		return us.registerUser(registration);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/auth/logInUser")
	public ResponseEntity<?> logInUser(@RequestBody LogInDTO logInUser){
		UserDTO opUser = us.logInUser(logInUser);
		if(opUser != null){
			return ResponseEntity.ok(opUser);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect credentials.");	
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/user/addFriend")
	public ResponseEntity<?> addFriend(@RequestBody FriendDTO friends){
		return us.createFriendship(friends);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/user/getFriends/{user}")
	public ResponseEntity<?> getFriends(@PathVariable String user){
		return us.getFriends(user);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/user/removeFriend")
	public ResponseEntity<?> removeFriend(@RequestBody FriendDTO friends){
		us.deleteFriend(friends);
		return ResponseEntity.ok(null);
	}
}
