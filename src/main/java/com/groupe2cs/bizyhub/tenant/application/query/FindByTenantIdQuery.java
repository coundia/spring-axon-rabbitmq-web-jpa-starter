package com.groupe2cs.bizyhub.tenant.application.query;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.TenantId;

public class FindByTenantIdQuery {

	private final TenantId id;

	public FindByTenantIdQuery(TenantId id) {
		this.id = id;
	}

	public TenantId getId() {
		return id;
	}
}
