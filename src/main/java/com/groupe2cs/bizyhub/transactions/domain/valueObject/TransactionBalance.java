package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionBalanceNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionBalance implements Serializable {

	private String balance;

	public TransactionBalance(String balance) {
		this.balance = balance;
	}

	public static TransactionBalance create(String balance) {
		if (balance == null || balance.isBlank()) {
			throw new TransactionBalanceNotValid("Balance is invalid");
		}
		return new TransactionBalance(balance);
	}

	public String value() {
		return this.balance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionBalance that)) return false;
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
