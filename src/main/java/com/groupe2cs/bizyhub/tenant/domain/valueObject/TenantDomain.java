package com.groupe2cs.bizyhub.tenant.domain.valueObject;

import com.groupe2cs.bizyhub.tenant.domain.exception.TenantDomainNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TenantDomain implements Serializable {

	private String domain;

	public TenantDomain(String domain) {
		this.domain = domain;
	}

	public static TenantDomain create(String domain) {
		if (domain == null || domain.isBlank()) {
			throw new TenantDomainNotValid("Domain is invalid");
		}
		return new TenantDomain(domain);
	}

	public String value() {
		return this.domain;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TenantDomain that)) return false;
		return this.domain.equals(that.domain);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(domain);
	}

	@Override
	public String toString() {
		return String.valueOf(domain);
	}
}
