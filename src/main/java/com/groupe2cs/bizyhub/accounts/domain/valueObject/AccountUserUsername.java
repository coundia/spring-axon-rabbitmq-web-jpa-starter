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
public class AccountUserUsername implements Serializable {

	private String username;

	public AccountUserUsername(String username) {
		this.username = username;
	}

	public static AccountUserUsername create(String username) {

		return new AccountUserUsername(username);
	}

	public String value() {
		return this.username;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountUserUsername that)) return false;
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
