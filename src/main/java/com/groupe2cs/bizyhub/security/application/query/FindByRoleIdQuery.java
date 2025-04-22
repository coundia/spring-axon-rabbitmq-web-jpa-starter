package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.RoleId;

public class FindByRoleIdQuery {

	private final RoleId id;

	public FindByRoleIdQuery(RoleId id) {
		this.id = id;
	}

	public RoleId getId() {
		return id;
	}
}
