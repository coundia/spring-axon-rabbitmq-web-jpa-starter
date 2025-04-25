package com.groupe2cs.bizyhub.tenant.application.query;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.TenantCreatedBy;

public class FindByTenantCreatedByQuery {

	private final TenantCreatedBy createdBy;

	public FindByTenantCreatedByQuery(TenantCreatedBy createdBy) {
		this.createdBy = createdBy;
	}

	public TenantCreatedBy getCreatedBy() {
		return createdBy;
	}
}
