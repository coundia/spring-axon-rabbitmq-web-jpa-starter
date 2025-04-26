package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleTenant;

public class FindByUserRoleTenantQuery {

	private final UserRoleTenant tenant;

	public FindByUserRoleTenantQuery(UserRoleTenant tenant) {
		this.tenant = tenant;
	}

	public UserRoleTenant getTenant() {
		return tenant;
	}
}
