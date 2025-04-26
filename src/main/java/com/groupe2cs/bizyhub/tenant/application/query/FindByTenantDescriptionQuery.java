package com.groupe2cs.bizyhub.tenant.application.query;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.TenantDescription;

public class FindByTenantDescriptionQuery {

	private final TenantDescription description;

	public FindByTenantDescriptionQuery(TenantDescription description) {
		this.description = description;
	}

	public TenantDescription getDescription() {
		return description;
	}
}
