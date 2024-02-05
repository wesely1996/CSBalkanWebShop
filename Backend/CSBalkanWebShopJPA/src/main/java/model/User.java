package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;

	private String password;

	private String username;

	// bi-directional many-to-one association to Favoriteproduct
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Favoriteproduct> favoriteproducts;

	// bi-directional many-to-one association to Shoppinglist
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Shoppinglist> shoppinglists;

	// bi-directional many-to-one association to Cart
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Cart> carts;

	// bi-directional many-to-one association to Friend
	@OneToMany(mappedBy = "user1")
	@JsonManagedReference
	private List<Friend> friends1;

	// bi-directional many-to-one association to Friend
	@OneToMany(mappedBy = "user2")
	@JsonManagedReference
	private List<Friend> friends2;

	// bi-directional many-to-one association to Inbox
	@OneToMany(mappedBy = "user1")
	@JsonManagedReference
	private List<Inbox> inboxs1;

	// bi-directional many-to-one association to Inbox
	@OneToMany(mappedBy = "user2")
	@JsonManagedReference
	private List<Inbox> inboxs2;

	// bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name = "idRole")
	@JsonBackReference
	private Role role;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Favoriteproduct> getFavoriteproducts() {
		return this.favoriteproducts;
	}

	public void setFavoriteproducts(List<Favoriteproduct> favoriteproducts) {
		this.favoriteproducts = favoriteproducts;
	}

	public Favoriteproduct addFavoriteproduct(Favoriteproduct favoriteproduct) {
		getFavoriteproducts().add(favoriteproduct);
		favoriteproduct.setUser(this);

		return favoriteproduct;
	}

	public Favoriteproduct removeFavoriteproduct(Favoriteproduct favoriteproduct) {
		getFavoriteproducts().remove(favoriteproduct);
		favoriteproduct.setUser(null);

		return favoriteproduct;
	}

	public List<Shoppinglist> getShoppinglists() {
		return this.shoppinglists;
	}

	public void setShoppinglists(List<Shoppinglist> shoppinglists) {
		this.shoppinglists = shoppinglists;
	}

	public Shoppinglist addShoppinglist(Shoppinglist shoppinglist) {
		getShoppinglists().add(shoppinglist);
		shoppinglist.setUser(this);

		return shoppinglist;
	}

	public Shoppinglist removeShoppinglist(Shoppinglist shoppinglist) {
		getShoppinglists().remove(shoppinglist);
		shoppinglist.setUser(null);

		return shoppinglist;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setUser(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setUser(null);

		return cart;
	}

	public List<Friend> getFriends1() {
		return this.friends1;
	}

	public void setFriends1(List<Friend> friends1) {
		this.friends1 = friends1;
	}

	public Friend addFriends1(Friend friends1) {
		getFriends1().add(friends1);
		friends1.setUser1(this);

		return friends1;
	}

	public Friend removeFriends1(Friend friends1) {
		getFriends1().remove(friends1);
		friends1.setUser1(null);

		return friends1;
	}

	public List<Friend> getFriends2() {
		return this.friends2;
	}

	public void setFriends2(List<Friend> friends2) {
		this.friends2 = friends2;
	}

	public Friend addFriends2(Friend friends2) {
		getFriends2().add(friends2);
		friends2.setUser2(this);

		return friends2;
	}

	public Friend removeFriends2(Friend friends2) {
		getFriends2().remove(friends2);
		friends2.setUser2(null);

		return friends2;
	}

	public List<Inbox> getInboxs1() {
		return this.inboxs1;
	}

	public void setInboxs1(List<Inbox> inboxs1) {
		this.inboxs1 = inboxs1;
	}

	public Inbox addInboxs1(Inbox inboxs1) {
		getInboxs1().add(inboxs1);
		inboxs1.setUser1(this);

		return inboxs1;
	}

	public Inbox removeInboxs1(Inbox inboxs1) {
		getInboxs1().remove(inboxs1);
		inboxs1.setUser1(null);

		return inboxs1;
	}

	public List<Inbox> getInboxs2() {
		return this.inboxs2;
	}

	public void setInboxs2(List<Inbox> inboxs2) {
		this.inboxs2 = inboxs2;
	}

	public Inbox addInboxs2(Inbox inboxs2) {
		getInboxs2().add(inboxs2);
		inboxs2.setUser2(this);

		return inboxs2;
	}

	public Inbox removeInboxs2(Inbox inboxs2) {
		getInboxs2().remove(inboxs2);
		inboxs2.setUser2(null);

		return inboxs2;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}