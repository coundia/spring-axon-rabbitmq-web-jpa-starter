package com.groupe2cs.bizyhub.security.domain.exception;

public class RefreshTokenUsernameNotValid extends RuntimeException {
	public RefreshTokenUsernameNotValid(String message) {
		super(message);
	}
}
