package com.groupe2cs.bizyhub.balances.domain.valueObject;

import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIsDefaultNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class BalanceIsDefault implements Serializable {

	private Boolean isDefault;

	public BalanceIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public static BalanceIsDefault create(Boolean isDefault) {
		if (isDefault == null) {
			throw new BalanceIsDefaultNotValid("IsDefault is invalid");
		}
		return new BalanceIsDefault(isDefault);
	}

	public Boolean value() {
		return this.isDefault;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BalanceIsDefault that)) return false;
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
