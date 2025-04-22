package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionPermission;

public class FindByRolePermissionPermissionQuery {

	private final RolePermissionPermission permission;

	public FindByRolePermissionPermissionQuery(RolePermissionPermission permission) {
		this.permission = permission;
	}

	public RolePermissionPermission getPermission() {
		return permission;
	}
}
