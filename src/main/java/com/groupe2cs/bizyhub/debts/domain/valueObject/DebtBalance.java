package com.groupe2cs.bizyhub.debts.domain.valueObject;

import com.groupe2cs.bizyhub.debts.domain.exception.DebtBalanceNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class DebtBalance implements Serializable {

	private Double balance;

	public DebtBalance(Double balance) {
		this.balance = balance;
	}

	public static DebtBalance create(Double balance) {

		if (balance == null) {
			throw new DebtBalanceNotValid("Balance is invalid");
		}
		return new DebtBalance(balance);
	}

	public Double value() {
		return this.balance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DebtBalance that)) return false;
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
