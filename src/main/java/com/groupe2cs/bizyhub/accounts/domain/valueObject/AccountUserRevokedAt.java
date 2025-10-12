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
public class AccountUserRevokedAt implements Serializable {

	private java.time.Instant revokedAt;

	public AccountUserRevokedAt(java.time.Instant revokedAt) {
		this.revokedAt = revokedAt;
	}

	public static AccountUserRevokedAt create(java.time.Instant revokedAt) {

		return new AccountUserRevokedAt(revokedAt);
	}

	public java.time.Instant value() {
		return this.revokedAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountUserRevokedAt that)) return false;
		return this.revokedAt.equals(that.revokedAt);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(revokedAt);
	}

	@Override
	public String toString() {
		return String.valueOf(revokedAt);
	}
}
