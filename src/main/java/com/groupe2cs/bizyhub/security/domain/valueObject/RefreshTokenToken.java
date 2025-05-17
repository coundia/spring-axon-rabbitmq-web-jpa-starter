package com.groupe2cs.bizyhub.security.domain.valueObject;

import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenTokenNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class RefreshTokenToken implements Serializable {

	private String token;

	public RefreshTokenToken(String token) {
		this.token = token;
	}

	public static RefreshTokenToken create(String token) {

		if (token == null || token.isBlank()) {
			throw new RefreshTokenTokenNotValid("Token is invalid");
		}
		return new RefreshTokenToken(token);
	}

	public String value() {
		return this.token;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RefreshTokenToken that)) return false;
		return this.token.equals(that.token);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(token);
	}

	@Override
	public String toString() {
		return String.valueOf(token);
	}
}
