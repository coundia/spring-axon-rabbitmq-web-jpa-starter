package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalanceNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class AccountBalance implements Serializable {

	private Double balance;

	public AccountBalance(Double balance) {
		this.balance = balance;
	}

	public static AccountBalance create(Double balance) {

		if (balance == null) {
			throw new AccountBalanceNotValid("Balance is invalid");
		}
		return new AccountBalance(balance);
	}

	public Double value() {
		return this.balance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountBalance that)) return false;
		return this.balance.equals(that.balance);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(balance);
	}

	@Override
	public String toString() {
		return String.valueOf(balance);
	}
}
