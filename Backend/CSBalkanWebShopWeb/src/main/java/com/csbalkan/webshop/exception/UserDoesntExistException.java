package com.csbalkan.webshop.exception;

public class UserDoesntExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserDoesntExistException(String msg) {
		super("User "+ msg +" doesn't exist.");
	}
}
