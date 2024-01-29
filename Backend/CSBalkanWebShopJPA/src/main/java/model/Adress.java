package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

/**
 * The persistent class for the adresses database table.
 * 
 */
@Entity
@Table(name = "adresses")
@NamedQuery(name = "Adress.findAll", query = "SELECT a FROM Adress a")
public class Adress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdresses;

	private String address;

	private String city;

	private String country;

	private int postalCode;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "idUsers")
	private User user;

	// bi-directional many-to-one association to Shoppinglist
	@OneToMany(mappedBy = "adress")
	private List<Shoppinglist> shoppinglists;

	public Adress() {
	}

	public int getIdAdresses() {
		return this.idAdresses;
	}

	public void setIdAdresses(int idAdresses) {
		this.idAdresses = idAdresses;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Shoppinglist> getShoppinglists() {
		return this.shoppinglists;
	}

	public void setShoppinglists(List<Shoppinglist> shoppinglists) {
		this.shoppinglists = shoppinglists;
	}

	public Shoppinglist addShoppinglist(Shoppinglist shoppinglist) {
		getShoppinglists().add(shoppinglist);
		shoppinglist.setAdress(this);

		return shoppinglist;
	}

	public Shoppinglist removeShoppinglist(Shoppinglist shoppinglist) {
		getShoppinglists().remove(shoppinglist);
		shoppinglist.setAdress(null);

		return shoppinglist;
	}

}