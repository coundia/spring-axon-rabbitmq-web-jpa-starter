package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetId;

public class FindByPasswordResetIdQuery {

	private final PasswordResetId id;

	public FindByPasswordResetIdQuery(PasswordResetId id) {
		this.id = id;
	}

	public PasswordResetId getId() {
		return id;
	}
}
