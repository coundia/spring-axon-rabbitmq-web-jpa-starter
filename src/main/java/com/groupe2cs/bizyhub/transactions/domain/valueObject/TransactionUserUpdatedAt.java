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
public class TransactionUserUpdatedAt implements Serializable {

	private java.time.Instant updatedAt;

	public TransactionUserUpdatedAt(java.time.Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	public static TransactionUserUpdatedAt create(java.time.Instant updatedAt) {

		return new TransactionUserUpdatedAt(updatedAt);
	}

	public java.time.Instant value() {
		return this.updatedAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionUserUpdatedAt that)) return false;
		return this.updatedAt.equals(that.updatedAt);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(updatedAt);
	}

	@Override
	public String toString() {
		return String.valueOf(updatedAt);
	}
}
