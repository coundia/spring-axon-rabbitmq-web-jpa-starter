package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByPasswordResetUsernameQuery {

private final PasswordResetUsername  username;

public FindByPasswordResetUsernameQuery( PasswordResetUsername username) {
	this.username = username;
}

public PasswordResetUsername  getUsername() {
return username;
}
}
