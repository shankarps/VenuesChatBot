package com.shankar.venues.model;

import java.util.Date;

public class Chat {

	private String message;
	
	private Date date;
	
	private Source source;

	public Chat() {
	}
	
	public Chat(String message, Source source) {
		this.message = message;
		this.source = source;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
