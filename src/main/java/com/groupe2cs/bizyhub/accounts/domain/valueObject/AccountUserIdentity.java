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
public class AccountUserIdentity implements Serializable {

	private String identity;

	public AccountUserIdentity(String identity) {
		this.identity = identity;
	}

	public static AccountUserIdentity create(String identity) {

		return new AccountUserIdentity(identity);
	}

	public String value() {
		return this.identity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountUserIdentity that)) return false;
		return this.identity.equals(that.identity);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(identity);
	}

	@Override
	public String toString() {
		return String.valueOf(identity);
	}
}
