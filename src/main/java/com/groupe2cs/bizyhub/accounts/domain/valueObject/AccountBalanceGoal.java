package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalanceGoalNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class AccountBalanceGoal implements Serializable {

	private Double balanceGoal;

	public AccountBalanceGoal(Double balanceGoal) {
		this.balanceGoal = balanceGoal;
	}

	public static AccountBalanceGoal create(Double balanceGoal) {

		if (balanceGoal == null) {
			throw new AccountBalanceGoalNotValid("BalanceGoal is invalid");
		}
		return new AccountBalanceGoal(balanceGoal);
	}

	public Double value() {
		return this.balanceGoal;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountBalanceGoal that)) return false;
		return this.balanceGoal.equals(that.balanceGoal);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(balanceGoal);
	}

	@Override
	public String toString() {
		return String.valueOf(balanceGoal);
	}
}
