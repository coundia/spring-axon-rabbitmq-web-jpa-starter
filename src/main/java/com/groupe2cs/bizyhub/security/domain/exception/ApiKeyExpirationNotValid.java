package com.groupe2cs.bizyhub.security.domain.exception;

public class ApiKeyExpirationNotValid extends RuntimeException {
	public ApiKeyExpirationNotValid(String message) {
		super(message);
	}
}
