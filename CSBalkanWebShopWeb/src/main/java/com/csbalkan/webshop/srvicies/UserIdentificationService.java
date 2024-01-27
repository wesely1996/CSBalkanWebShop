package com.csbalkan.webshop.srvicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csbalkan.webshop.dto.UserDTO;
import com.csbalkan.webshop.repositories.ShoppingListRepository;
import com.csbalkan.webshop.repositories.UserRepository;

import model.User;

@Service
public class UserIdentificationService {
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	ShoppingListRepository slr;
	
	public Boolean checkIfUserExists(String username) {
		return ur.findByUsername(username)!=null;
	}
	
	public int createNewUser(UserDTO newUser) {
		User nu = new User();
		if(checkIfUserExists(newUser.getUsername()))
			return 1;
		if(newUser.getDisplayName()!="")
			nu.setDisplayName(newUser.getDisplayName());
		nu.setUsername(newUser.getUsername());
		nu.setPassword(newUser.getPassword());
		try {
			ur.save(nu);
		} catch(Exception e) {
			return -1;
		}
		return 0;
	}
	
	public int logIn(UserDTO user) {
		User u = ur.findByUsername(user.getUsername());
		if(u == null)
			return -2;
		if(u.getPassword().equals(user.getPassword()))
			return 0;
		return -1;
	}
}
