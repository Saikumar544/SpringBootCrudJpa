package com.example.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiHandling extends RuntimeException{
	private Date timestamp;
	private String message;

	public ApiHandling(Date localDate, String message) {
		this.timestamp = localDate;
		this.message = message;
	}


	public ApiHandling() {
		super();
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
}
