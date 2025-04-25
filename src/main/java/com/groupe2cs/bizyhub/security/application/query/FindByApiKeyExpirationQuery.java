package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByApiKeyExpirationQuery {

private final ApiKeyExpiration  expiration;

public FindByApiKeyExpirationQuery( ApiKeyExpiration expiration) {
	this.expiration = expiration;
}

public ApiKeyExpiration  getExpiration() {
return expiration;
}
}
