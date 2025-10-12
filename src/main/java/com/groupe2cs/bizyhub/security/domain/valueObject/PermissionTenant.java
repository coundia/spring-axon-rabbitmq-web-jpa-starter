package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.security.domain.exception.PermissionIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PermissionNameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PermissionCreatedByNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.PermissionTenantNotValid;

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
public class PermissionTenant implements Serializable {

	private String tenant;

	public PermissionTenant(String tenant) {
		this.tenant = tenant;
	}

	public static PermissionTenant create(String tenant) {

		return new PermissionTenant(tenant);
	}

	public String value() {
		return this.tenant;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PermissionTenant that)) return false;
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
