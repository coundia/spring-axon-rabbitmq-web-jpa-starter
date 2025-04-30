package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionUpdatedAtNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionUpdatedAt implements Serializable {

	private java.time.Instant updatedAt;

	public TransactionUpdatedAt(java.time.Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	public static TransactionUpdatedAt create(java.time.Instant updatedAt) {
		if (updatedAt == null) {
			throw new TransactionUpdatedAtNotValid("UpdatedAt is invalid");
		}
		return new TransactionUpdatedAt(updatedAt);
	}

	public java.time.Instant value() {
		return this.updatedAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionUpdatedAt that)) return false;
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
