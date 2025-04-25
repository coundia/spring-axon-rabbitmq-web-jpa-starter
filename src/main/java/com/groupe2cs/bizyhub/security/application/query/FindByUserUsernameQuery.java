package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByUserUsernameQuery {

private final UserUsername  username;

public FindByUserUsernameQuery( UserUsername username) {
	this.username = username;
}

public UserUsername  getUsername() {
return username;
}
}
