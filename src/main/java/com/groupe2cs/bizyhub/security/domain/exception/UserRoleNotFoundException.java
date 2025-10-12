package com.groupe2cs.bizyhub.security.domain.exception;

import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleId;

public class UserRoleNotFoundException extends RuntimeException {

	public UserRoleNotFoundException(String object, String value) {
		super("UserRole with " + object + ": '" + value + "' not found");
	}
}
