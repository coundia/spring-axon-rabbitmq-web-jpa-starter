package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyAppKey;

public class FindByApiKeyAppKeyQuery {

	private final ApiKeyAppKey appKey;

	public FindByApiKeyAppKeyQuery(ApiKeyAppKey appKey) {
		this.appKey = appKey;
	}

	public ApiKeyAppKey getAppKey() {
		return appKey;
	}
}
