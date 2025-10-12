package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.security.domain.exception.UserRoleIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserRoleUserNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserRoleRoleNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserRoleCreatedByNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserRoleTenantNotValid;

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
public class UserRoleTenant implements Serializable {

	private String tenant;

	public UserRoleTenant(String tenant) {
		this.tenant = tenant;
	}

	public static UserRoleTenant create(String tenant) {

		return new UserRoleTenant(tenant);
	}

	public String value() {
		return this.tenant;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserRoleTenant that)) return false;
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
