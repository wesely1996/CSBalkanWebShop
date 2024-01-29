package com.csbalkan.webshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.csbalkan.webshop.dto.LogInDTO;
import com.csbalkan.webshop.dto.UserDTO;
import com.csbalkan.webshop.exception.UserAlreadyExistsException;
import com.csbalkan.webshop.exception.UserDoesntExistException;
import com.csbalkan.webshop.repositories.UserRepository;

import model.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User registerUser(UserDTO userdto) throws UserAlreadyExistsException{
		if (ur.findByUsernameIgnoreCase(userdto.getUsername()).isPresent() 
				|| ur.findByEmailIgnoreCase(userdto.getEmail()).isPresent()) {
			throw new UserAlreadyExistsException("User with this email or username already exists.");
		}
		User user = new User();
		user.setUsername(userdto.getUsername());
		user.setFirstName(userdto.getFirstName());
		user.setLastName(userdto.getLastName());
		user.setDisplayName(userdto.getDisplayName());
		user.setEmail(userdto.getEmail());
		user.setPassword(passwordEncoder.encode(userdto.getPassword()));
		user = ur.save(user);
		return user;
	}
	
	public UserDTO logInUser(LogInDTO userdto) {
		Optional<User> opUser = ur.findByUsernameIgnoreCase(userdto.getUsername());
		if(opUser.isPresent()) {
			User user = opUser.get();
			if(passwordEncoder.matches(userdto.getPassword(), user.getPassword())) {
				UserDTO u = new UserDTO();
				u.setUsername(user.getUsername());
				u.setDisplayName(user.getDisplayName());
				u.setEmail(user.getEmail());
				u.setLastName(user.getLastName());
				u.setFirstName(u.getFirstName());
				return u;
			}
		}
		return null;
	}
}
