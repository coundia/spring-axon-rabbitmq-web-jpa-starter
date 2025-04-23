package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByApiKeyUsernameQuery {

private final ApiKeyUsername  username;

public FindByApiKeyUsernameQuery( ApiKeyUsername username) {
	this.username = username;
}

public ApiKeyUsername  getUsername() {
return username;
}
}
