package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.RoleCreatedBy;

public class FindByRoleCreatedByQuery {

	private final RoleCreatedBy createdBy;

	public FindByRoleCreatedByQuery(RoleCreatedBy createdBy) {
		this.createdBy = createdBy;
	}

	public RoleCreatedBy getCreatedBy() {
		return createdBy;
	}
}
