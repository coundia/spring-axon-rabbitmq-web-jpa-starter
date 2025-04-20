package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByUserEmailQuery {

private final UserEmail  email;

public FindByUserEmailQuery( UserEmail email) {
	this.email = email;
}

public UserEmail  getEmail() {
return email;
}
}
