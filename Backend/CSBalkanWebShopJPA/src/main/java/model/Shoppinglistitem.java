package model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

/**
 * The persistent class for the shoppinglistitems database table.
 * 
 */
@Entity
@Table(name = "shoppinglistitems")
@NamedQuery(name = "Shoppinglistitem.findAll", query = "SELECT s FROM Shoppinglistitem s")
public class Shoppinglistitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private double price;

	private int quantity;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "idProducts")
	@JsonBackReference
	private Product product;

	// bi-directional many-to-one association to Shoppinglist
	@ManyToOne
	@JoinColumn(name = "idShoppingList")
	@JsonBackReference
	private Shoppinglist shoppinglist;

	public Shoppinglistitem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Shoppinglist getShoppinglist() {
		return this.shoppinglist;
	}

	public void setShoppinglist(Shoppinglist shoppinglist) {
		this.shoppinglist = shoppinglist;
	}

}