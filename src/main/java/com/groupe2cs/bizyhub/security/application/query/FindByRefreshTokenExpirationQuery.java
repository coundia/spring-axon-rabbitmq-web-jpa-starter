package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenExpiration;

public class FindByRefreshTokenExpirationQuery {

	private final RefreshTokenExpiration expiration;

	public FindByRefreshTokenExpirationQuery(RefreshTokenExpiration expiration) {
		this.expiration = expiration;
	}

	public RefreshTokenExpiration getExpiration() {
		return expiration;
	}
}
