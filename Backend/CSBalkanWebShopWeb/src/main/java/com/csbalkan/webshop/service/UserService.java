package com.csbalkan.webshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.csbalkan.webshop.dto.FriendDTO;
import com.csbalkan.webshop.dto.LogInDTO;
import com.csbalkan.webshop.dto.UserDTO;
import com.csbalkan.webshop.repositories.FriendRepository;
import com.csbalkan.webshop.repositories.ProductReposiotry;
import com.csbalkan.webshop.repositories.RoleRepository;
import com.csbalkan.webshop.repositories.UserRepository;

import model.Friend;
import model.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	ProductReposiotry pr;
	
	@Autowired
	RoleRepository rr;
	
	@Autowired
	FriendRepository fr;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public ResponseEntity<?> registerUser(UserDTO userdto){
		if (ur.findByUsernameIgnoreCase(userdto.getUsername()).isPresent() 
				|| ur.findByEmailIgnoreCase(userdto.getEmail()).isPresent()) {
			return ResponseEntity.badRequest().body("User already exists.\nUsername: "+userdto.getUsername()+" Email: "+userdto.getEmail());
		}
		if (rr.findByName(userdto.getRole()).isEmpty()){
			return ResponseEntity.badRequest().body(userdto.getRole()+" doesn't exist.");
		}
		User user = new User();
		user.setUsername(userdto.getUsername());
		user.setEmail(userdto.getEmail());
		user.setPassword(passwordEncoder.encode(userdto.getPassword()));
		user.setRole(rr.findByName(userdto.getRole()).get());
		ur.save(user);
		return ResponseEntity.ok(user);
	}
	
	public UserDTO logInUser(LogInDTO userdto) {
		Optional<User> opUser = ur.findByUsernameIgnoreCase(userdto.getUsername());
		if(opUser.isPresent()) {
			User user = opUser.get();
			if(passwordEncoder.matches(userdto.getPassword(), user.getPassword())) {
				UserDTO u = new UserDTO();
				u.setUsername(user.getUsername());
				u.setEmail(user.getEmail());
				u.setRole(user.getRole().getName());
				return u;
			}
		}
		return null;
	}
	
	public ResponseEntity<?> createFriendship(FriendDTO friends) {
		User user = ur.findByUsername(friends.getUsername());
		if(user == null)
			return ResponseEntity.badRequest().body("User " + friends.getUsername() + " doesn't exist;");
		User friend = ur.findByUsername(friends.getFriend());
		if(friend == null)
			return ResponseEntity.badRequest().body("User " + friends.getFriend() + " doesn't exist;");
		Friend f = new Friend();
		f.setUser1(user);
		f.setUser2(friend);
		f = fr.save(f);
		if(f == null)
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Faied to save friendship.");
		return ResponseEntity.ok("SUCCESS");
	}
	
	public ResponseEntity<?> getFriends(String username){
		return ResponseEntity.ok(fr.findFriendsForUser(username));
	}
	
	public void deleteFriend(FriendDTO firends){
		fr.deleteFriendsByIds(firends.getUsername(), firends.getFriend());
	}
}
