package com.groupe2cs.bizyhub.security.presentation.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class SecurityExceptionHandler {

	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<?> handleBadCredentials(BadCredentialsException ex) {
	return buildResponse("Invalid credentials", HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<?> handleUserNotFound(UsernameNotFoundException ex) {
	return buildResponse("User not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<?> handleAccessDenied(AccessDeniedException ex) {
	return buildResponse("Access denied", HttpStatus.FORBIDDEN);
	}

	private ResponseEntity<Map<String, String>> buildResponse(String message, HttpStatus status) {
	Map<String, String> body = new HashMap<>();
	body.put("error", message);
	return new ResponseEntity<>(body, status);
	}
}
