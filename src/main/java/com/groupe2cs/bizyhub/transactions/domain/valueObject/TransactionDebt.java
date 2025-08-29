package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionDebt implements Serializable {

	private String debt;

	public TransactionDebt(String debt) {
		this.debt = debt;
	}

	public static TransactionDebt create(String debt) {

		return new TransactionDebt(debt);
	}

	public String value() {
		return this.debt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionDebt that)) return false;
		return this.debt.equals(that.debt);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(debt);
	}

	@Override
	public String toString() {
		return String.valueOf(debt);
	}
}
