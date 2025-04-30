package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDateOperationNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionDateOperation implements Serializable {

	private java.time.Instant dateOperation;

	public TransactionDateOperation(java.time.Instant dateOperation) {
		this.dateOperation = dateOperation;
	}

	public static TransactionDateOperation create(java.time.Instant dateOperation) {
		if (dateOperation == null) {
			throw new TransactionDateOperationNotValid("DateOperation is invalid");
		}
		return new TransactionDateOperation(dateOperation);
	}

	public java.time.Instant value() {
		return this.dateOperation;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionDateOperation that)) return false;
		return this.dateOperation.equals(that.dateOperation);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(dateOperation);
	}

	@Override
	public String toString() {
		return String.valueOf(dateOperation);
	}
}
