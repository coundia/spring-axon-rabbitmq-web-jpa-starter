package com.groupe2cs.bizyhub.security.domain.exception;

public class VerificationCodeExpirationNotValid extends RuntimeException {
	public VerificationCodeExpirationNotValid(String message) {
		super(message);
	}
}
