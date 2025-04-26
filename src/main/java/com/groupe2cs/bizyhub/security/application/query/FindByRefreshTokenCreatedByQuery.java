package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenCreatedBy;

public class FindByRefreshTokenCreatedByQuery {

	private final RefreshTokenCreatedBy createdBy;

	public FindByRefreshTokenCreatedByQuery(RefreshTokenCreatedBy createdBy) {
		this.createdBy = createdBy;
	}

	public RefreshTokenCreatedBy getCreatedBy() {
		return createdBy;
	}
}
