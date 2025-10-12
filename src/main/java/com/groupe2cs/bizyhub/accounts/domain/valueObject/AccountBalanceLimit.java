package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalanceLimitNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class AccountBalanceLimit implements Serializable {

	private Double balanceLimit;

	public AccountBalanceLimit(Double balanceLimit) {
		this.balanceLimit = balanceLimit;
	}

	public static AccountBalanceLimit create(Double balanceLimit) {

		if (balanceLimit == null) {
			throw new AccountBalanceLimitNotValid("BalanceLimit is invalid");
		}
		return new AccountBalanceLimit(balanceLimit);
	}

	public Double value() {
		return this.balanceLimit;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountBalanceLimit that)) return false;
		return this.balanceLimit.equals(that.balanceLimit);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(balanceLimit);
	}

	@Override
	public String toString() {
		return String.valueOf(balanceLimit);
	}
}
