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
public class AccountUserUser implements Serializable {

	private String user;

	public AccountUserUser(String user) {
		this.user = user;
	}

	public static AccountUserUser create(String user) {

		return new AccountUserUser(user);
	}

	public String value() {
		return this.user;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountUserUser that)) return false;
		return this.user.equals(that.user);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(user);
	}

	@Override
	public String toString() {
		return String.valueOf(user);
	}
}
