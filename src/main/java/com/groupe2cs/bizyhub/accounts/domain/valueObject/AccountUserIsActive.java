package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIsActiveNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class AccountUserIsActive implements Serializable {

	private Boolean isActive;

	public AccountUserIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public static AccountUserIsActive create(Boolean isActive) {

		if (isActive == null) {
			throw new AccountUserIsActiveNotValid("IsActive is invalid");
		}
		return new AccountUserIsActive(isActive);
	}

	public Boolean value() {
		return this.isActive;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountUserIsActive that)) return false;
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
