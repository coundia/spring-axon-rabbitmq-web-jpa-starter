package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenTokenNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenExpirationNotValid;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class RefreshTokenExpiration implements Serializable {

	private java.time.Instant expiration;

	public RefreshTokenExpiration(java.time.Instant expiration) {
		this.expiration = expiration;
	}

	public static RefreshTokenExpiration create(java.time.Instant expiration) {

		if (expiration == null) {
			throw new RefreshTokenExpirationNotValid("Expiration is invalid");
		}
		return new RefreshTokenExpiration(expiration);
	}

	public java.time.Instant value() {
		return this.expiration;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RefreshTokenExpiration that)) return false;
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
