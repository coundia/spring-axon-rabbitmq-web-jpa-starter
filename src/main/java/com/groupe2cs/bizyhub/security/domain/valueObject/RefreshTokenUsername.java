package com.groupe2cs.bizyhub.security.domain.valueObject;

import com.groupe2cs.bizyhub.security.domain.exception.RefreshTokenUsernameNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class RefreshTokenUsername implements Serializable {

	private String username;

	public RefreshTokenUsername(String username) {
		this.username = username;
	}

	public static RefreshTokenUsername create(String username) {
		if (username == null || username.isBlank()) {
			throw new RefreshTokenUsernameNotValid("Username is invalid");
		}
		return new RefreshTokenUsername(username);
	}

	public String value() {
		return this.username;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RefreshTokenUsername that)) return false;
		return this.username.equals(that.username);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(username);
	}

	@Override
	public String toString() {
		return String.valueOf(username);
	}
}
