package com.csbalkan.webshop.dto;

public class FavoriteDTO {

	private String user;
	private Integer product;
	
	public FavoriteDTO() {
		super();
	}

	public FavoriteDTO(String user, Integer product) {
		super();
		this.user = user;
		this.product = product;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Integer getProduct() {
		return product;
	}

	public void setProduct(Integer product) {
		this.product = product;
	}
	
	
}
