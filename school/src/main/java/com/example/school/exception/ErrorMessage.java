package com.example.school.exception;

public class ErrorMessage {

	private String messageId;
	private String message;
	public ErrorMessage() {
	}
	public ErrorMessage(String messageId, String message) {
		this.messageId = messageId;
		this.message = message;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
