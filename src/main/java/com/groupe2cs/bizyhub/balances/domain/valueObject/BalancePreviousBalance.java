package com.groupe2cs.bizyhub.balances.domain.valueObject;

import com.groupe2cs.bizyhub.balances.domain.exception.BalancePreviousBalanceNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class BalancePreviousBalance implements Serializable {

	private Double previousBalance;

	public BalancePreviousBalance(Double previousBalance) {
		this.previousBalance = previousBalance;
	}

	public static BalancePreviousBalance create(Double previousBalance) {
		if (previousBalance == null) {
			throw new BalancePreviousBalanceNotValid("PreviousBalance is invalid");
		}
		return new BalancePreviousBalance(previousBalance);
	}

	public Double value() {
		return this.previousBalance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BalancePreviousBalance that)) return false;
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
