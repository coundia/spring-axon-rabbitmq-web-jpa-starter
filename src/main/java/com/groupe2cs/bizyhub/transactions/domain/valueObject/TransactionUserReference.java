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
public class TransactionUserReference implements Serializable {

	private String reference;

	public TransactionUserReference(String reference) {
		this.reference = reference;
	}

	public static TransactionUserReference create(String reference) {

		return new TransactionUserReference(reference);
	}

	public String value() {
		return this.reference;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionUserReference that)) return false;
		return this.reference.equals(that.reference);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(reference);
	}

	@Override
	public String toString() {
		return String.valueOf(reference);
	}
}
