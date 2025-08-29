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
public class AccountIsDefault implements Serializable {

	private Boolean isDefault;

	public AccountIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public static AccountIsDefault create(Boolean isDefault) {

		return new AccountIsDefault(isDefault);
	}

	public Boolean value() {
		return this.isDefault;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountIsDefault that)) return false;
		return this.isDefault.equals(that.isDefault);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isDefault);
	}

	@Override
	public String toString() {
		return String.valueOf(isDefault);
	}
}
