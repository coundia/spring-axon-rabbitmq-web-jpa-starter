package com.groupe2cs.bizyhub.security.domain.exception;

public class UserRoleNotFoundException extends RuntimeException {

	public UserRoleNotFoundException(String object, String value) {
		super("UserRole with " + object + ": '" + value + "' not found");
	}
}
