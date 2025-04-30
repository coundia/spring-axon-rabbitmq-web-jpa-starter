package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCreatedAtNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionCreatedAt implements Serializable {

	private java.time.Instant createdAt;

	public TransactionCreatedAt(java.time.Instant createdAt) {
		this.createdAt = createdAt;
	}

	public static TransactionCreatedAt create(java.time.Instant createdAt) {
		if (createdAt == null) {
			throw new TransactionCreatedAtNotValid("CreatedAt is invalid");
		}
		return new TransactionCreatedAt(createdAt);
	}

	public java.time.Instant value() {
		return this.createdAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionCreatedAt that)) return false;
		return this.createdAt.equals(that.createdAt);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(createdAt);
	}

	@Override
	public String toString() {
		return String.valueOf(createdAt);
	}
}
