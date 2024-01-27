package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

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
	private int idUsers;

	private String displayName;

	private int idCart;

	private String password;

	private String username;

	// bi-directional many-to-one association to Friendslist
	@OneToMany(mappedBy = "user1")
	private List<Friendslist> friendslists1;

	// bi-directional many-to-one association to Friendslist
	@OneToMany(mappedBy = "user2")
	private List<Friendslist> friendslists2;

	// bi-directional many-to-one association to Message
	@OneToMany(mappedBy = "user1")
	private List<Message> messages1;

	// bi-directional many-to-one association to Message
	@OneToMany(mappedBy = "user2")
	private List<Message> messages2;

	// bi-directional many-to-one association to Shoppinglist
	@OneToMany(mappedBy = "user")
	private List<Shoppinglist> shoppinglists;

	public User() {
	}

	public int getIdUsers() {
		return this.idUsers;
	}

	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getIdCart() {
		return this.idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
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

	public List<Friendslist> getFriendslists1() {
		return this.friendslists1;
	}

	public void setFriendslists1(List<Friendslist> friendslists1) {
		this.friendslists1 = friendslists1;
	}

	public Friendslist addFriendslists1(Friendslist friendslists1) {
		getFriendslists1().add(friendslists1);
		friendslists1.setUser1(this);

		return friendslists1;
	}

	public Friendslist removeFriendslists1(Friendslist friendslists1) {
		getFriendslists1().remove(friendslists1);
		friendslists1.setUser1(null);

		return friendslists1;
	}

	public List<Friendslist> getFriendslists2() {
		return this.friendslists2;
	}

	public void setFriendslists2(List<Friendslist> friendslists2) {
		this.friendslists2 = friendslists2;
	}

	public Friendslist addFriendslists2(Friendslist friendslists2) {
		getFriendslists2().add(friendslists2);
		friendslists2.setUser2(this);

		return friendslists2;
	}

	public Friendslist removeFriendslists2(Friendslist friendslists2) {
		getFriendslists2().remove(friendslists2);
		friendslists2.setUser2(null);

		return friendslists2;
	}

	public List<Message> getMessages1() {
		return this.messages1;
	}

	public void setMessages1(List<Message> messages1) {
		this.messages1 = messages1;
	}

	public Message addMessages1(Message messages1) {
		getMessages1().add(messages1);
		messages1.setUser1(this);

		return messages1;
	}

	public Message removeMessages1(Message messages1) {
		getMessages1().remove(messages1);
		messages1.setUser1(null);

		return messages1;
	}

	public List<Message> getMessages2() {
		return this.messages2;
	}

	public void setMessages2(List<Message> messages2) {
		this.messages2 = messages2;
	}

	public Message addMessages2(Message messages2) {
		getMessages2().add(messages2);
		messages2.setUser2(this);

		return messages2;
	}

	public Message removeMessages2(Message messages2) {
		getMessages2().remove(messages2);
		messages2.setUser2(null);

		return messages2;
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

}