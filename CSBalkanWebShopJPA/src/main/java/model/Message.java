package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;

/**
 * The persistent class for the messages database table.
 * 
 */
@Entity
@Table(name = "messages")
@NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMessages;

	private int idConversation;

	private String message;

	private String subject;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "idSender")
	private User user1;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "idReciver")
	private User user2;

	public Message() {
	}

	public int getIdMessages() {
		return this.idMessages;
	}

	public void setIdMessages(int idMessages) {
		this.idMessages = idMessages;
	}

	public int getIdConversation() {
		return this.idConversation;
	}

	public void setIdConversation(int idConversation) {
		this.idConversation = idConversation;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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