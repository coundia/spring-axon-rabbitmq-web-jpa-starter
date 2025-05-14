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
public class TransactionTypeTransactionRaw implements Serializable {

	private String typeTransactionRaw;

	public TransactionTypeTransactionRaw(String typeTransactionRaw) {
		this.typeTransactionRaw = typeTransactionRaw;
	}

	public static TransactionTypeTransactionRaw create(String typeTransactionRaw) {

		return new TransactionTypeTransactionRaw(typeTransactionRaw);
	}

	public String value() {
		return this.typeTransactionRaw;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionTypeTransactionRaw that)) return false;
		return this.typeTransactionRaw.equals(that.typeTransactionRaw);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(typeTransactionRaw);
	}

	@Override
	public String toString() {
		return String.valueOf(typeTransactionRaw);
	}
}
