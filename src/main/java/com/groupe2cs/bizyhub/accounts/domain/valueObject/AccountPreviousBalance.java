package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import com.groupe2cs.bizyhub.accounts.domain.exception.AccountPreviousBalanceNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class AccountPreviousBalance implements Serializable {

	private Double previousBalance;

	public AccountPreviousBalance(Double previousBalance) {
		this.previousBalance = previousBalance;
	}

	public static AccountPreviousBalance create(Double previousBalance) {

		if (previousBalance == null) {
			throw new AccountPreviousBalanceNotValid("PreviousBalance is invalid");
		}
		return new AccountPreviousBalance(previousBalance);
	}

	public Double value() {
		return this.previousBalance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountPreviousBalance that)) return false;
		return this.previousBalance.equals(that.previousBalance);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(previousBalance);
	}

	@Override
	public String toString() {
		return String.valueOf(previousBalance);
	}
}
