package com.csbalkan.webshop.dto;

import java.math.BigDecimal;

public class ProductDTO {

	private int idProducts;

	private String description;

	private String image;

	private String name;

	private BigDecimal price;

	private String type;

	public int getIdProducts() {
		return idProducts;
	}

	public void setIdProducts(int idProducts) {
		this.idProducts = idProducts;
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
	
	
}
