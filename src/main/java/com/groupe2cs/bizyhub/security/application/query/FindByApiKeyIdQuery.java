package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByApiKeyIdQuery {

private final ApiKeyId  id;

public FindByApiKeyIdQuery( ApiKeyId id) {
	this.id = id;
}

public ApiKeyId  getId() {
return id;
}
}
