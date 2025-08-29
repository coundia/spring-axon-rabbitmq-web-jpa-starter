package com.groupe2cs.bizyhub.customers.domain.valueObject;

import com.groupe2cs.bizyhub.customers.domain.exception.CustomerBalanceDebtNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CustomerBalanceDebt implements Serializable {

	private Double balanceDebt;

	public CustomerBalanceDebt(Double balanceDebt) {
		this.balanceDebt = balanceDebt;
	}

	public static CustomerBalanceDebt create(Double balanceDebt) {

		if (balanceDebt == null) {
			throw new CustomerBalanceDebtNotValid("BalanceDebt is invalid");
		}
		return new CustomerBalanceDebt(balanceDebt);
	}

	public Double value() {
		return this.balanceDebt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CustomerBalanceDebt that)) return false;
		return this.balanceDebt.equals(that.balanceDebt);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(balanceDebt);
	}

	@Override
	public String toString() {
		return String.valueOf(balanceDebt);
	}
}
