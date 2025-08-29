package com.groupe2cs.bizyhub.security.domain.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String object, String value) {
		super("User with " + object + ": '" + value + "' not found");
	}
}
