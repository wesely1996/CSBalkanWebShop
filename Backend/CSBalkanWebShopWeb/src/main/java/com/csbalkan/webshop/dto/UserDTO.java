package com.csbalkan.webshop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDTO {

	@NotNull(message = "Invalid Username: Null")
	@NotBlank(message = "Invalid Username: Empty")
	@Size(min = 3, message = "{validation.username.size.too_short}")
	@Size(max = 31, message = "{validation.username.size.too_long}")
	private String username;
	@NotNull(message = "Invalid Password: Null")
	@NotBlank(message = "Invalid Password: Empty")
	@Size(min = 5, message = "{validation.password.size.too_short}")
	@Size(max = 31, message = "{validation.password.size.too_long}")
	private String password;
	@Email(message = "Invalid Email")
	@NotBlank(message = "Invalid Email: Empty")
	@Size(max = 127, message = "{validation.email.size.too_long}")
	private String email;
	
	private String role;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
