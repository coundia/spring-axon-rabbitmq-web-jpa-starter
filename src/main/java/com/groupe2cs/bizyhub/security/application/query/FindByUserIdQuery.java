package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByUserIdQuery {

private final UserId  id;

public FindByUserIdQuery( UserId id) {
	this.id = id;
}

public UserId  getId() {
return id;
}
}
