package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenTokenNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenExpirationNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenCreatedByNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenTenantNotValid;

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
public class RefreshTokenTenant implements Serializable {

	private String tenant;

	public RefreshTokenTenant(String tenant) {
		this.tenant = tenant;
	}

	public static RefreshTokenTenant create(String tenant) {

		return new RefreshTokenTenant(tenant);
	}

	public String value() {
		return this.tenant;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RefreshTokenTenant that)) return false;
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
