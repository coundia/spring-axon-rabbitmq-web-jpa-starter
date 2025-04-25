package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByPermissionCreatedByQuery {

private final PermissionCreatedBy  createdBy;

public FindByPermissionCreatedByQuery( PermissionCreatedBy createdBy) {
	this.createdBy = createdBy;
}

public PermissionCreatedBy  getCreatedBy() {
return createdBy;
}
}
