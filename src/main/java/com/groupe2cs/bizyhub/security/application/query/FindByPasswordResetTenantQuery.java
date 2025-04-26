package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetTenant;

public class FindByPasswordResetTenantQuery {

	private final PasswordResetTenant tenant;

	public FindByPasswordResetTenantQuery(PasswordResetTenant tenant) {
		this.tenant = tenant;
	}

	public PasswordResetTenant getTenant() {
		return tenant;
	}
}
