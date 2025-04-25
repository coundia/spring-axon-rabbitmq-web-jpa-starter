package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByPasswordResetTokenQuery {

private final PasswordResetToken  token;

public FindByPasswordResetTokenQuery( PasswordResetToken token) {
	this.token = token;
}

public PasswordResetToken  getToken() {
return token;
}
}
