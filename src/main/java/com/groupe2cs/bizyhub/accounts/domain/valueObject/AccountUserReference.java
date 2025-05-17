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
public class AccountUserReference implements Serializable {

	private String reference;

	public AccountUserReference(String reference) {
		this.reference = reference;
	}

	public static AccountUserReference create(String reference) {

		return new AccountUserReference(reference);
	}

	public String value() {
		return this.reference;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountUserReference that)) return false;
		return this.reference.equals(that.reference);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(reference);
	}

	@Override
	public String toString() {
		return String.valueOf(reference);
	}
}
