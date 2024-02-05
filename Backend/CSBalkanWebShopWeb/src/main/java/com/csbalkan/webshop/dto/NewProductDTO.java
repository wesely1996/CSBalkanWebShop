package com.csbalkan.webshop.dto;

import java.math.BigDecimal;

public class NewProductDTO {

	private String description;

	private String image;

	private String name;

	private BigDecimal price;

	private String type;
	
	private int quantity;

	public NewProductDTO(String description, String image, String name, BigDecimal price, String type, int quantity) {
		super();
		this.description = description;
		this.image = image;
		this.name = name;
		this.price = price;
		this.type = type;
		this.setQuantity(quantity);
	}

	public NewProductDTO() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
