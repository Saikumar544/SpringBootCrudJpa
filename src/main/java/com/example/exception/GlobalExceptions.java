package com.example.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

	/*
	 * @ExceptionHandler(value = ApiHandling.class)
	 * 
	 * @ResponseStatus(code = HttpStatus.NOT_FOUND) public ApiHandling
	 * exception(Exception exception) { ApiHandling api = new ApiHandling(new
	 * Date(), exception.getMessage()); return api; }
	 * 
	 * @ExceptionHandler(value = ConstraintViolationException.class)
	 * 
	 * @ResponseStatus(code = HttpStatus.BAD_REQUEST) public ApiHandling
	 * exception1(ConstraintViolationException exception) { ApiHandling api = new
	 * ApiHandling(); api.setMessage(exception.getMessage()); api.setTimestamp(new
	 * Date()); return api; }
	 */
	@ExceptionHandler(value=ApiHandling.class)
	public ResponseEntity<Object> handleAnyException(Exception ex) {
		ApiHandling apiHandling = new ApiHandling(new Date(), ex.getMessage());
		return new ResponseEntity<>(apiHandling,new HttpHeaders(),HttpStatus.NOT_FOUND);
	}

	/*
	 * @ExceptionHandler(value=ApiHandling.class) public ResponseEntity<Object>
	 * apiExcepiton(ApiHandling api){ return new ResponseEntity<Object>() }
	 */
}
