package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByPasswordResetCreatedByQuery {

private final PasswordResetCreatedBy  createdBy;

public FindByPasswordResetCreatedByQuery( PasswordResetCreatedBy createdBy) {
	this.createdBy = createdBy;
}

public PasswordResetCreatedBy  getCreatedBy() {
return createdBy;
}
}
