package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByPermissionTenantQuery {

private final PermissionTenant  tenant;

public FindByPermissionTenantQuery( PermissionTenant tenant) {
	this.tenant = tenant;
}

public PermissionTenant  getTenant() {
return tenant;
}
}
