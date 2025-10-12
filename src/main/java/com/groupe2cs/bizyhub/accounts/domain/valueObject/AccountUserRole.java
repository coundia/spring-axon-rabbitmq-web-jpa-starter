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
public class AccountUserRole implements Serializable {

	private String role;

	public AccountUserRole(String role) {
		this.role = role;
	}

	public static AccountUserRole create(String role) {

		return new AccountUserRole(role);
	}

	public String value() {
		return this.role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountUserRole that)) return false;
		return this.role.equals(that.role);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(role);
	}

	@Override
	public String toString() {
		return String.valueOf(role);
	}
}
