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
	@NotNull(message = "Invalid First Name: Null")
	@NotBlank(message = "Invalid First Name: Empty")
	@Size(max = 63, message = "{validation.first_name.size.too_long}")
	private String firstName;
	@NotNull(message = "Invalid Last Name: Null")
	@NotBlank(message = "Invalid Last Name: Empty")
	@Size(max = 127, message = "{validation.last_name.size.too_long}")
	private String lastName;
	@Size(max = 31, message = "{validation.display_name.size.too_long}")
	private String displayName;
	
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	
}
