package com.groupe2cs.bizyhub.security.domain.exception;

public class RefreshTokenNotFoundException extends RuntimeException {

	public RefreshTokenNotFoundException(String object, String value) {
		super("RefreshToken with " + object + ": '" + value + "' not found");
	}
}
