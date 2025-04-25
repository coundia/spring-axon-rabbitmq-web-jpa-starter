package com.groupe2cs.bizyhub.tenant.application.query;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;

public class FindByTenantDomainQuery {

private final TenantDomain  domain;

public FindByTenantDomainQuery( TenantDomain domain) {
	this.domain = domain;
}

public TenantDomain  getDomain() {
return domain;
}
}
