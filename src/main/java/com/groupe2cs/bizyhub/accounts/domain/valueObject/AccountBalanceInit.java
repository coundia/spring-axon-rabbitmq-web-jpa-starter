package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalanceInitNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class AccountBalanceInit implements Serializable {

	private Double balanceInit;

	public AccountBalanceInit(Double balanceInit) {
		this.balanceInit = balanceInit;
	}

	public static AccountBalanceInit create(Double balanceInit) {

		if (balanceInit == null) {
			throw new AccountBalanceInitNotValid("BalanceInit is invalid");
		}
		return new AccountBalanceInit(balanceInit);
	}

	public Double value() {
		return this.balanceInit;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountBalanceInit that)) return false;
		return this.balanceInit.equals(that.balanceInit);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(balanceInit);
	}

	@Override
	public String toString() {
		return String.valueOf(balanceInit);
	}
}
