package com.groupe2cs.bizyhub.balances.domain.valueObject;

import com.groupe2cs.bizyhub.balances.domain.exception.BalanceCurrentBalanceNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class BalanceCurrentBalance implements Serializable {

	private Double currentBalance;

	public BalanceCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public static BalanceCurrentBalance create(Double currentBalance) {
		if (currentBalance == null) {
			throw new BalanceCurrentBalanceNotValid("CurrentBalance is invalid");
		}
		return new BalanceCurrentBalance(currentBalance);
	}

	public Double value() {
		return this.currentBalance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BalanceCurrentBalance that)) return false;
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
