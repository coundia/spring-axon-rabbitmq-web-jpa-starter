package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyCreatedBy;

public class FindByApiKeyCreatedByQuery {

	private final ApiKeyCreatedBy createdBy;

	public FindByApiKeyCreatedByQuery(ApiKeyCreatedBy createdBy) {
		this.createdBy = createdBy;
	}

	public ApiKeyCreatedBy getCreatedBy() {
		return createdBy;
	}
}
