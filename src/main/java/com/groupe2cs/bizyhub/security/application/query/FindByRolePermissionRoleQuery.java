package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByRolePermissionRoleQuery {

private final RolePermissionRole  role;

public FindByRolePermissionRoleQuery( RolePermissionRole role) {
	this.role = role;
}

public RolePermissionRole  getRole() {
return role;
}
}
