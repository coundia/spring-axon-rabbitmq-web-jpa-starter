package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleId;

public class FindByUserRoleIdQuery {

	private final UserRoleId id;

	public FindByUserRoleIdQuery(UserRoleId id) {
		this.id = id;
	}

	public UserRoleId getId() {
		return id;
	}
}
