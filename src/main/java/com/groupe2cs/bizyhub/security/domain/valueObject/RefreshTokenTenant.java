package com.groupe2cs.bizyhub.security.domain.valueObject;

import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenTenantNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

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
		if (tenant == null || tenant.isBlank()) {
			throw new RefreshTokenTenantNotValid("Tenant is invalid");
		}
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
