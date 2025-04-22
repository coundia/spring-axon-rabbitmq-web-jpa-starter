package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.UserPassword;

public class FindByUserPasswordQuery {

	private final UserPassword password;

	public FindByUserPasswordQuery(UserPassword password) {
		this.password = password;
	}

	public UserPassword getPassword() {
		return password;
	}
}
