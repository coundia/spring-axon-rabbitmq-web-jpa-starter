package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByUserRoleCreatedByQuery {

private final UserRoleCreatedBy  createdBy;

public FindByUserRoleCreatedByQuery( UserRoleCreatedBy createdBy) {
	this.createdBy = createdBy;
}

public UserRoleCreatedBy  getCreatedBy() {
return createdBy;
}
}
