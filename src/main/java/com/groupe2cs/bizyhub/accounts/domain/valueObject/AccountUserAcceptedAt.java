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
public class AccountUserAcceptedAt implements Serializable {

	private java.time.Instant acceptedAt;

	public AccountUserAcceptedAt(java.time.Instant acceptedAt) {
		this.acceptedAt = acceptedAt;
	}

	public static AccountUserAcceptedAt create(java.time.Instant acceptedAt) {

		return new AccountUserAcceptedAt(acceptedAt);
	}

	public java.time.Instant value() {
		return this.acceptedAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountUserAcceptedAt that)) return false;
		return this.acceptedAt.equals(that.acceptedAt);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(acceptedAt);
	}

	@Override
	public String toString() {
		return String.valueOf(acceptedAt);
	}
}
