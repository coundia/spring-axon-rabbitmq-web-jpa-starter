package com.groupe2cs.bizyhub.security.domain.valueObject;

import com.groupe2cs.bizyhub.security.domain.exception.UserRoleTenantNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

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
		if (tenant == null || tenant.isBlank()) {
			throw new UserRoleTenantNotValid("Tenant is invalid");
		}
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
