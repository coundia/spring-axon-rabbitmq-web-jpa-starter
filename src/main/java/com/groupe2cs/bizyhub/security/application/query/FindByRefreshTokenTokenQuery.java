package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenToken;

public class FindByRefreshTokenTokenQuery {

	private final RefreshTokenToken token;

	public FindByRefreshTokenTokenQuery(RefreshTokenToken token) {
		this.token = token;
	}

	public RefreshTokenToken getToken() {
		return token;
	}
}
