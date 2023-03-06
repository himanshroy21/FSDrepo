package com.customerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.customerservice.exception.CustomerNotFoundException;
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<String> CustomerNotFound(CustomerNotFoundException e) {
		return new ResponseEntity<>("Customer Not Found", HttpStatus.NOT_FOUND);
}
}

