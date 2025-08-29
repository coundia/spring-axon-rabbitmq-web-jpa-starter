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
public class TransactionUserTransaction implements Serializable {

	private String transaction;

	public TransactionUserTransaction(String transaction) {
		this.transaction = transaction;
	}

	public static TransactionUserTransaction create(String transaction) {

		return new TransactionUserTransaction(transaction);
	}

	public String value() {
		return this.transaction;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionUserTransaction that)) return false;
		return this.transaction.equals(that.transaction);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(transaction);
	}

	@Override
	public String toString() {
		return String.valueOf(transaction);
	}
}
