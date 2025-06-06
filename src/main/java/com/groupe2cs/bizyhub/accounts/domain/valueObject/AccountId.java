package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIdNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class AccountId implements Serializable {

	private String id;

	public AccountId(String id) {
		this.id = id;
	}

	public static AccountId create(String id) {

		if (id == null || id.isBlank()) {
			throw new AccountIdNotValid("Id is invalid");
		}
		return new AccountId(id);
	}

	public String value() {
		return this.id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountId that)) return false;
		return this.id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(id);
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
