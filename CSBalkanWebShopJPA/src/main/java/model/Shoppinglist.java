package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the shoppinglists database table.
 * 
 */
@Entity
@Table(name = "shoppinglists")
@NamedQuery(name = "Shoppinglist.findAll", query = "SELECT s FROM Shoppinglist s")
public class Shoppinglist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idShoppingList;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	// bi-directional many-to-one association to Shoppinglistitem
	@OneToMany(mappedBy = "shoppinglist")
	private List<Shoppinglistitem> shoppinglistitems;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "idUsers")
	private User user;

	public Shoppinglist() {
	}

	public int getIdShoppingList() {
		return this.idShoppingList;
	}

	public void setIdShoppingList(int idShoppingList) {
		this.idShoppingList = idShoppingList;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public List<Shoppinglistitem> getShoppinglistitems() {
		return this.shoppinglistitems;
	}

	public void setShoppinglistitems(List<Shoppinglistitem> shoppinglistitems) {
		this.shoppinglistitems = shoppinglistitems;
	}

	public Shoppinglistitem addShoppinglistitem(Shoppinglistitem shoppinglistitem) {
		getShoppinglistitems().add(shoppinglistitem);
		shoppinglistitem.setShoppinglist(this);

		return shoppinglistitem;
	}

	public Shoppinglistitem removeShoppinglistitem(Shoppinglistitem shoppinglistitem) {
		getShoppinglistitems().remove(shoppinglistitem);
		shoppinglistitem.setShoppinglist(null);

		return shoppinglistitem;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}