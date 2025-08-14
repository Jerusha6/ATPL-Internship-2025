package com.aaslin.CustomValidatorIntegration.model;

public class Errors {
	private String message;
	private int status;
	private long timestamp;
	
	public Errors(String message, int status) {
		super();
		this.message = message;
		this.status = status;
		this.timestamp = System.currentTimeMillis();
	}
	public String getMessage() {
		return message;
	}
	public int getStatus() {
		return status;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
}
