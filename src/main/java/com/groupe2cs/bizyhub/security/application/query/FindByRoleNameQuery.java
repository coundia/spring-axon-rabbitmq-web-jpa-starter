package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByRoleNameQuery {

private final RoleName  name;

public FindByRoleNameQuery( RoleName name) {
	this.name = name;
}

public RoleName  getName() {
return name;
}
}
