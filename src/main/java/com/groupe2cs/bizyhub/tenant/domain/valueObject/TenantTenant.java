package com.groupe2cs.bizyhub.tenant.domain.valueObject;

import com.groupe2cs.bizyhub.tenant.domain.exception.TenantTenantNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TenantTenant implements Serializable {

	private String tenant;

	public TenantTenant(String tenant) {
		this.tenant = tenant;
	}

	public static TenantTenant create(String tenant) {
		if (tenant == null || tenant.isBlank()) {
			throw new TenantTenantNotValid("Tenant is invalid");
		}
		return new TenantTenant(tenant);
	}

	public String value() {
		return this.tenant;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TenantTenant that)) return false;
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
