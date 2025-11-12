package com.groupe2cs.bizyhub.security.domain.exception;

public class ApiKeyNotFoundException extends RuntimeException {

	public ApiKeyNotFoundException(String object, String value) {
		super("ApiKey with " + object + ": '" + value + "' not found");
	}
}
