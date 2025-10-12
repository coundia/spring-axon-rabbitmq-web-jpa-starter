package com.groupe2cs.bizyhub.security.domain.exception;

public class PasswordResetCreatedByNotValid extends RuntimeException {
	public PasswordResetCreatedByNotValid(String message) {
		super(message);
	}
}
