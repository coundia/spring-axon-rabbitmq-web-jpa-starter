package com.groupe2cs.bizyhub.security.domain.exception;

public class RoleNotFoundException extends RuntimeException {

	public RoleNotFoundException(String object, String value) {
		super("Role with " + object + ": '" + value + "' not found");
	}
}
