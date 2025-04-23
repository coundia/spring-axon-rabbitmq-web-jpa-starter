package com.groupe2cs.bizyhub.security.domain.valueObject;

import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyExpirationNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ApiKeyExpiration implements Serializable {

	private java.time.Instant expiration;

	public ApiKeyExpiration(java.time.Instant expiration) {
		this.expiration = expiration;
	}

	public static ApiKeyExpiration create(java.time.Instant expiration) {
		if (expiration == null) {
			throw new ApiKeyExpirationNotValid("Expiration is invalid");
		}
		return new ApiKeyExpiration(expiration);
	}

	public java.time.Instant value() {
		return this.expiration;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ApiKeyExpiration that)) return false;
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
