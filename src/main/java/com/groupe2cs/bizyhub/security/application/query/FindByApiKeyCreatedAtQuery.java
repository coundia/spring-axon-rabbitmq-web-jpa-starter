package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByApiKeyCreatedAtQuery {

private final ApiKeyCreatedAt  createdAt;

public FindByApiKeyCreatedAtQuery( ApiKeyCreatedAt createdAt) {
	this.createdAt = createdAt;
}

public ApiKeyCreatedAt  getCreatedAt() {
return createdAt;
}
}
