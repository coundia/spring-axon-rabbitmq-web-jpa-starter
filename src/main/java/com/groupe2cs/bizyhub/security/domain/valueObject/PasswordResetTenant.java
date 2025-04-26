package com.groupe2cs.bizyhub.security.domain.valueObject;

import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetTenantNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

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
		if (tenant == null || tenant.isBlank()) {
			throw new PasswordResetTenantNotValid("Tenant is invalid");
		}
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
