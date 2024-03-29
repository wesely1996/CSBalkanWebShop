package com.csbalkan.webshop.dto;

public class CartDTO {
	private String user;
	private Integer product;
	private Integer amount;
	
	public CartDTO(String user, Integer product, Integer amount) {
		super();
		this.user = user;
		this.product = product;
		this.amount = amount;
	}

	public CartDTO() {
		super();
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
