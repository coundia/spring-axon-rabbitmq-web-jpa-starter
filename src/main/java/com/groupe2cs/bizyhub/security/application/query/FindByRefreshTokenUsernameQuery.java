package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenUsername;

public class FindByRefreshTokenUsernameQuery {

	private final RefreshTokenUsername username;

	public FindByRefreshTokenUsernameQuery(RefreshTokenUsername username) {
		this.username = username;
	}

	public RefreshTokenUsername getUsername() {
		return username;
	}
}
