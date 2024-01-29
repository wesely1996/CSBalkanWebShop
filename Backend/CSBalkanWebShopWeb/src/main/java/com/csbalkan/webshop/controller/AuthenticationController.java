package com.csbalkan.webshop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csbalkan.webshop.dto.LogInDTO;
import com.csbalkan.webshop.dto.UserDTO;
import com.csbalkan.webshop.exception.UserAlreadyExistsException;
import com.csbalkan.webshop.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	UserService us;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/registerUser")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserDTO registration) {
		try {
			us.registerUser(registration);
			return ResponseEntity.ok().build();
		} catch(UserAlreadyExistsException e){
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/logInUser")
	public ResponseEntity<?> logInUser(@RequestBody LogInDTO logInUser){
		UserDTO opUser = us.logInUser(logInUser);
		if(opUser != null){
			return ResponseEntity.ok(opUser);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
		}
	}
}
