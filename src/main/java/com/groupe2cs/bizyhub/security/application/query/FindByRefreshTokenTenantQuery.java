package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByRefreshTokenTenantQuery {

private final RefreshTokenTenant  tenant;

public FindByRefreshTokenTenantQuery( RefreshTokenTenant tenant) {
	this.tenant = tenant;
}

public RefreshTokenTenant  getTenant() {
return tenant;
}
}
