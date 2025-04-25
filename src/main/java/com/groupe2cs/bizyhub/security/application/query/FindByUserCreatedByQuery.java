package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByUserCreatedByQuery {

private final UserCreatedBy  createdBy;

public FindByUserCreatedByQuery( UserCreatedBy createdBy) {
	this.createdBy = createdBy;
}

public UserCreatedBy  getCreatedBy() {
return createdBy;
}
}
