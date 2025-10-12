package com.groupe2cs.bizyhub.security.domain.exception;

public class VerificationCodeTenantNotValid extends RuntimeException {
	public VerificationCodeTenantNotValid(String message) {
		super(message);
	}
}
