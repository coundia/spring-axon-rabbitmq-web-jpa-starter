package com.groupe2cs.bizyhub.security.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class VerificationCodeExpiration implements Serializable {

	private java.time.Instant expiration;

	public VerificationCodeExpiration(java.time.Instant expiration) {
		this.expiration = expiration;
	}

	public static VerificationCodeExpiration create(java.time.Instant expiration) {

		return new VerificationCodeExpiration(expiration);
	}

	public java.time.Instant value() {
		return this.expiration;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof VerificationCodeExpiration that)) return false;
		return this.expiration.equals(that.expiration);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(expiration);
	}

	@Override
	public String toString() {
		return String.valueOf(expiration);
	}
}
