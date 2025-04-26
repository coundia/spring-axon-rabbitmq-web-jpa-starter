package com.groupe2cs.bizyhub.tenant.application.query;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.TenantActive;

public class FindByTenantActiveQuery {

	private final TenantActive active;

	public FindByTenantActiveQuery(TenantActive active) {
		this.active = active;
	}

	public TenantActive getActive() {
		return active;
	}
}
