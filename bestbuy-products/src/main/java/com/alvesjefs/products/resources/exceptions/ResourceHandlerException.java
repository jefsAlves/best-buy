package com.alvesjefs.products.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alvesjefs.products.services.exceptions.IdNotFoundException;
import com.alvesjefs.products.services.exceptions.ProductAlreadyExistsException;

@ControllerAdvice
public class ResourceHandlerException {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<StandardError> idNotFoundException(IdNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError();
		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setError("Resource not found!");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}

//	@ExceptionHandler(NameNotFoundException.class)
//	public ResponseEntity<StandardError> nameNotFound(NameNotFoundException e, HttpServletRequest request) {
//		HttpStatus status = HttpStatus.NOT_FOUND;
//		StandardError error = new StandardError();
//		error.setTimestamp(Instant.now());
//		error.setStatus(status.value());
//		error.setError("Resource not found!");
//		error.setMessage(e.getMessage());
//		error.setPath(request.getRequestURI());
//		return ResponseEntity.status(status).body(error);
//	}

	@ExceptionHandler(ProductAlreadyExistsException.class)
	public ResponseEntity<StandardError> productAlreadyExists(ProductAlreadyExistsException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError error = new StandardError();
		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setError("Resource not found!");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
}
