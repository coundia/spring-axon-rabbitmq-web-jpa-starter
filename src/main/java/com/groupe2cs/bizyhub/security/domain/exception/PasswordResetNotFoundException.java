package com.groupe2cs.bizyhub.security.domain.exception;

import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetId;

public class PasswordResetNotFoundException extends RuntimeException {

	public PasswordResetNotFoundException(String object, String value) {
		super("PasswordReset with " + object + ": '" + value + "' not found");
	}
}
