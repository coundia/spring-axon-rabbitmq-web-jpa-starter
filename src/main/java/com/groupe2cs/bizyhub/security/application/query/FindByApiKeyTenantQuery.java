package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyTenant;

public class FindByApiKeyTenantQuery {

	private final ApiKeyTenant tenant;

	public FindByApiKeyTenantQuery(ApiKeyTenant tenant) {
		this.tenant = tenant;
	}

	public ApiKeyTenant getTenant() {
		return tenant;
	}
}
