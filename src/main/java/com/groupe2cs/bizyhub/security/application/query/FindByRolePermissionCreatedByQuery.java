package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionCreatedBy;

public class FindByRolePermissionCreatedByQuery {

	private final RolePermissionCreatedBy createdBy;

	public FindByRolePermissionCreatedByQuery(RolePermissionCreatedBy createdBy) {
		this.createdBy = createdBy;
	}

	public RolePermissionCreatedBy getCreatedBy() {
		return createdBy;
	}
}
