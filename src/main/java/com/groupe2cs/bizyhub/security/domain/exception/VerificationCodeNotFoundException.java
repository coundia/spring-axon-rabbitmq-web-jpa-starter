package com.groupe2cs.bizyhub.security.domain.exception;

public class VerificationCodeNotFoundException extends RuntimeException {

	public VerificationCodeNotFoundException(String object, String value) {
		super("VerificationCode with " + object + ": '" + value + "' not found");
	}
}
