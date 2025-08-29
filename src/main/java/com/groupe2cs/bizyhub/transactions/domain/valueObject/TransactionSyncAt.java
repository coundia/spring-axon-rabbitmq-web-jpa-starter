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
public class TransactionSyncAt implements Serializable {

	private java.time.Instant syncAt;

	public TransactionSyncAt(java.time.Instant syncAt) {
		this.syncAt = syncAt;
	}

	public static TransactionSyncAt create(java.time.Instant syncAt) {

		return new TransactionSyncAt(syncAt);
	}

	public java.time.Instant value() {
		return this.syncAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionSyncAt that)) return false;
		return this.syncAt.equals(that.syncAt);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(syncAt);
	}

	@Override
	public String toString() {
		return String.valueOf(syncAt);
	}
}
