package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyKey;

public class FindByApiKeyKeyQuery {

	private final ApiKeyKey key;

	public FindByApiKeyKeyQuery(ApiKeyKey key) {
		this.key = key;
	}

	public ApiKeyKey getKey() {
		return key;
	}
}
