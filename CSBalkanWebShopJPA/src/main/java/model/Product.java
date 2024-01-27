package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name = "products")
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducts;

	private String description;

	private String image;

	private String name;

	private BigDecimal price;

	private int quantity;

	private String type;

	// bi-directional many-to-one association to Shoppinglistitem
	@OneToMany(mappedBy = "product")
	private List<Shoppinglistitem> shoppinglistitems;

	public Product() {
	}

	public int getIdProducts() {
		return this.idProducts;
	}

	public void setIdProducts(int idProducts) {
		this.idProducts = idProducts;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Shoppinglistitem> getShoppinglistitems() {
		return this.shoppinglistitems;
	}

	public void setShoppinglistitems(List<Shoppinglistitem> shoppinglistitems) {
		this.shoppinglistitems = shoppinglistitems;
	}

	public Shoppinglistitem addShoppinglistitem(Shoppinglistitem shoppinglistitem) {
		getShoppinglistitems().add(shoppinglistitem);
		shoppinglistitem.setProduct(this);

		return shoppinglistitem;
	}

	public Shoppinglistitem removeShoppinglistitem(Shoppinglistitem shoppinglistitem) {
		getShoppinglistitems().remove(shoppinglistitem);
		shoppinglistitem.setProduct(null);

		return shoppinglistitem;
	}

}