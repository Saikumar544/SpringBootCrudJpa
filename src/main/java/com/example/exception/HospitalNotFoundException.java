package com.example.exception;

import org.springframework.stereotype.Component;

@Component
public class HospitalNotFoundException extends RuntimeException {
	
	public HospitalNotFoundException() {
		super();
	}
	private String message;
	public HospitalNotFoundException(String message) {
		super(message);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
