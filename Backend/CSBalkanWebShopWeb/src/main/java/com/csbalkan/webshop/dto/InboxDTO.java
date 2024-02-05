package com.csbalkan.webshop.dto;

import java.util.Date;


public class InboxDTO {

	private String message;

	private String subject;

	private Date timestamp;
	
	private String sender;
	
	private String reciver;

	public InboxDTO() {
		super();
	}

	public InboxDTO(String message, String subject, Date timestamp, String sender, String reciver) {
		super();
		this.message = message;
		this.subject = subject;
		this.timestamp = timestamp;
		this.sender = sender;
		this.reciver = reciver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReciver() {
		return reciver;
	}

	public void setReciver(String reciver) {
		this.reciver = reciver;
	}
}
