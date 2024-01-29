package model;

import java.io.Serializable;
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
	private int idFavoriteProducts;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "idProduct")
	private Product product;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "idUsers")
	private User user;

	public Favoriteproduct() {
	}

	public int getIdFavoriteProducts() {
		return this.idFavoriteProducts;
	}

	public void setIdFavoriteProducts(int idFavoriteProducts) {
		this.idFavoriteProducts = idFavoriteProducts;
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