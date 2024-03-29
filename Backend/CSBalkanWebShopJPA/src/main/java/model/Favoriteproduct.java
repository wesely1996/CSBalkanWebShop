package model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

/**
 * The persistent class for the favoriteproducts database table.
 * 
 */
@Entity
@Table(name = "favoriteproducts")
@NamedQuery(name = "Favoriteproduct.findAll", query = "SELECT f FROM Favoriteproduct f")
public class Favoriteproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "idProduct")
	@JsonBackReference
	private Product product;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "idUsers")
	@JsonBackReference
	private User user;

	public Favoriteproduct() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}