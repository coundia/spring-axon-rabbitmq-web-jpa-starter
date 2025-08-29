package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalanceBlockedNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class AccountBalanceBlocked implements Serializable {

	private Double balanceBlocked;

	public AccountBalanceBlocked(Double balanceBlocked) {
		this.balanceBlocked = balanceBlocked;
	}

	public static AccountBalanceBlocked create(Double balanceBlocked) {

		if (balanceBlocked == null) {
			throw new AccountBalanceBlockedNotValid("BalanceBlocked is invalid");
		}
		return new AccountBalanceBlocked(balanceBlocked);
	}

	public Double value() {
		return this.balanceBlocked;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountBalanceBlocked that)) return false;
		return this.balanceBlocked.equals(that.balanceBlocked);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(balanceBlocked);
	}

	@Override
	public String toString() {
		return String.valueOf(balanceBlocked);
	}
}
