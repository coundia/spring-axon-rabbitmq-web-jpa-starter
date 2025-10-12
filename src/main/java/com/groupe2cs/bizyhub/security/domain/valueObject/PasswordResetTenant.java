package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetTokenNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetExpirationNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetCreatedByNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetTenantNotValid;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class PasswordResetTenant implements Serializable {

	private String tenant;

	public PasswordResetTenant(String tenant) {
		this.tenant = tenant;
	}

	public static PasswordResetTenant create(String tenant) {

		return new PasswordResetTenant(tenant);
	}

	public String value() {
		return this.tenant;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PasswordResetTenant that)) return false;
		return this.tenant.equals(that.tenant);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(tenant);
	}

	@Override
	public String toString() {
		return String.valueOf(tenant);
	}
}
