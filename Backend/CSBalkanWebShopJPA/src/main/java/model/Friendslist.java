package model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The persistent class for the friendslist database table.
 * 
 */
@Entity
@NamedQuery(name = "Friendslist.findAll", query = "SELECT f FROM Friendslist f")
public class Friendslist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFriendsList;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user1;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "idFriend")
	private User user2;

	public Friendslist() {
	}

	public int getIdFriendsList() {
		return this.idFriendsList;
	}

	public void setIdFriendsList(int idFriendsList) {
		this.idFriendsList = idFriendsList;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}