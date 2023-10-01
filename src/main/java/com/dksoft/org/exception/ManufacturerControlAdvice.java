package com.dksoft.org.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManufacturerControlAdvice {

	@ExceptionHandler(ManufacturerNotFoundException.class)
	public ResponseEntity<ErrorResonse> handleManufacturerException(ManufacturerNotFoundException ex) {
		ErrorResonse response = new ErrorResonse();
		response.setHttpStatus(HttpStatus.NOT_FOUND);
		response.setLocation("BANGLORE");
		response.setMessage(ex.getMessage());
		return ResponseEntity.ok(response);
	}
}
