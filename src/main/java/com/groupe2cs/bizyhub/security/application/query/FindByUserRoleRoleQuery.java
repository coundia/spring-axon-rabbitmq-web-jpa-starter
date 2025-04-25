package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByUserRoleRoleQuery {

private final UserRoleRole  role;

public FindByUserRoleRoleQuery( UserRoleRole role) {
	this.role = role;
}

public UserRoleRole  getRole() {
return role;
}
}
