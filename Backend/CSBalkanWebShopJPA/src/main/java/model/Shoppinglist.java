package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	// bi-directional many-to-one association to Shoppinglistitem
	@OneToMany(mappedBy = "shoppinglist")
	@JsonManagedReference
	private List<Shoppinglistitem> shoppinglistitems;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "idUsers")
	@JsonBackReference
	private User user;

	public Shoppinglist() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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