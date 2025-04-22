package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleUser;

public class FindByUserRoleUserQuery {

	private final UserRoleUser user;

	public FindByUserRoleUserQuery(UserRoleUser user) {
		this.user = user;
	}

	public UserRoleUser getUser() {
		return user;
	}
}
