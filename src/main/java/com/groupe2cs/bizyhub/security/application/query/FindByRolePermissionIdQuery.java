package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionId;

public class FindByRolePermissionIdQuery {

	private final RolePermissionId id;

	public FindByRolePermissionIdQuery(RolePermissionId id) {
		this.id = id;
	}

	public RolePermissionId getId() {
		return id;
	}
}
