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
public class AccountUserEmail implements Serializable {

	private String email;

	public AccountUserEmail(String email) {
		this.email = email;
	}

	public static AccountUserEmail create(String email) {

		return new AccountUserEmail(email);
	}

	public String value() {
		return this.email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountUserEmail that)) return false;
		return this.email.equals(that.email);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(email);
	}

	@Override
	public String toString() {
		return String.valueOf(email);
	}
}
