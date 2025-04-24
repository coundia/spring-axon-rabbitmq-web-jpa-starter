package com.groupe2cs.bizyhub.security.domain.exception;

public class ApiKeyCreatedByNotValid extends RuntimeException {
	public ApiKeyCreatedByNotValid(String message) {
		super(message);
	}
}
