package com.groupe2cs.bizyhub.tenant.application.query;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;

public class FindByTenantLanguageQuery {

private final TenantLanguage  language;

public FindByTenantLanguageQuery( TenantLanguage language) {
	this.language = language;
}

public TenantLanguage  getLanguage() {
return language;
}
}
