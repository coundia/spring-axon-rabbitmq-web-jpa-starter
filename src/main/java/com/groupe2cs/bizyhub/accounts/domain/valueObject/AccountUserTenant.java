package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class AccountUserTenant implements Serializable {

	private String tenant;

	public AccountUserTenant(String tenant) {
		this.tenant = tenant;
	}

	public static AccountUserTenant create(String tenant) {

		return new AccountUserTenant(tenant);
	}

	public String value() {
		return this.tenant;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountUserTenant that)) return false;
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
