package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.RoleTenant;

public class FindByRoleTenantQuery {

	private final RoleTenant tenant;

	public FindByRoleTenantQuery(RoleTenant tenant) {
		this.tenant = tenant;
	}

	public RoleTenant getTenant() {
		return tenant;
	}
}
