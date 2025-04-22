package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetExpiration;

public class FindByPasswordResetExpirationQuery {

	private final PasswordResetExpiration expiration;

	public FindByPasswordResetExpirationQuery(PasswordResetExpiration expiration) {
		this.expiration = expiration;
	}

	public PasswordResetExpiration getExpiration() {
		return expiration;
	}
}
