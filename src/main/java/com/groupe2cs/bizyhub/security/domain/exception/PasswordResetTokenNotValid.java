package com.groupe2cs.bizyhub.security.domain.exception;

public class PasswordResetTokenNotValid extends RuntimeException {
	public PasswordResetTokenNotValid(String message) {
		super(message);
	}
}
