package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import com.groupe2cs.bizyhub.accounts.domain.exception.AccountIsActiveNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class AccountIsActive implements Serializable {

	private Boolean isActive;

	public AccountIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public static AccountIsActive create(Boolean isActive) {

		if (isActive == null) {
			throw new AccountIsActiveNotValid("IsActive is invalid");
		}
		return new AccountIsActive(isActive);
	}

	public Boolean value() {
		return this.isActive;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountIsActive that)) return false;
		return this.isActive.equals(that.isActive);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isActive);
	}

	@Override
	public String toString() {
		return String.valueOf(isActive);
	}
}
