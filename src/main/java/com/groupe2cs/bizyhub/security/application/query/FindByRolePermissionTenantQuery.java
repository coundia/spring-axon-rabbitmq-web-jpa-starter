package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByRolePermissionTenantQuery {

private final RolePermissionTenant  tenant;

public FindByRolePermissionTenantQuery( RolePermissionTenant tenant) {
	this.tenant = tenant;
}

public RolePermissionTenant  getTenant() {
return tenant;
}
}
