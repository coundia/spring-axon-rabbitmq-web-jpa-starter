package com.groupe2cs.bizyhub.security.domain.exception;

public class RefreshTokenIdNotValid extends RuntimeException {
	public RefreshTokenIdNotValid(String message) {
		super(message);
	}
}
