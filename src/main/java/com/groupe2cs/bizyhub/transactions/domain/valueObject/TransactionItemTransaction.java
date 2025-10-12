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
public class TransactionItemTransaction implements Serializable {

	private String transaction;

	public TransactionItemTransaction(String transaction) {
		this.transaction = transaction;
	}

	public static TransactionItemTransaction create(String transaction) {

		return new TransactionItemTransaction(transaction);
	}

	public String value() {
		return this.transaction;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionItemTransaction that)) return false;
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
