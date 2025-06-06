package com.groupe2cs.bizyhub.security.domain.valueObject;

import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyUsernameNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ApiKeyUsername implements Serializable {

	private String username;

	public ApiKeyUsername(String username) {
		this.username = username;
	}

	public static ApiKeyUsername create(String username) {

		if (username == null || username.isBlank()) {
			throw new ApiKeyUsernameNotValid("Username is invalid");
		}
		return new ApiKeyUsername(username);
	}

	public String value() {
		return this.username;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ApiKeyUsername that)) return false;
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
