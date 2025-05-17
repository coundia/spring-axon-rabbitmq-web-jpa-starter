package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCurrentBalanceNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class AccountCurrentBalance implements Serializable {

	private Double currentBalance;

	public AccountCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public static AccountCurrentBalance create(Double currentBalance) {

		if (currentBalance == null) {
			throw new AccountCurrentBalanceNotValid("CurrentBalance is invalid");
		}
		return new AccountCurrentBalance(currentBalance);
	}

	public Double value() {
		return this.currentBalance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountCurrentBalance that)) return false;
		return this.currentBalance.equals(that.currentBalance);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(currentBalance);
	}

	@Override
	public String toString() {
		return String.valueOf(currentBalance);
	}
}
