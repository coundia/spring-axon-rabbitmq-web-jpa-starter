package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.UserTenant;

public class FindByUserTenantQuery {

	private final UserTenant tenant;

	public FindByUserTenantQuery(UserTenant tenant) {
		this.tenant = tenant;
	}

	public UserTenant getTenant() {
		return tenant;
	}
}
