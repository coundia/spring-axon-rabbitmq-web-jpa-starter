package com.groupe2cs.bizyhub.tenant.application.query;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.TenantName;

public class FindByTenantNameQuery {

	private final TenantName name;

	public FindByTenantNameQuery(TenantName name) {
		this.name = name;
	}

	public TenantName getName() {
		return name;
	}
}
