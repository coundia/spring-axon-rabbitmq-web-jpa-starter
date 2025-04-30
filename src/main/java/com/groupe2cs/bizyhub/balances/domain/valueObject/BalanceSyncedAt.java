package com.groupe2cs.bizyhub.balances.domain.valueObject;

import com.groupe2cs.bizyhub.balances.domain.exception.BalanceSyncedAtNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class BalanceSyncedAt implements Serializable {

	private java.time.Instant syncedAt;

	public BalanceSyncedAt(java.time.Instant syncedAt) {
		this.syncedAt = syncedAt;
	}

	public static BalanceSyncedAt create(java.time.Instant syncedAt) {
		if (syncedAt == null) {
			throw new BalanceSyncedAtNotValid("SyncedAt is invalid");
		}
		return new BalanceSyncedAt(syncedAt);
	}

	public java.time.Instant value() {
		return this.syncedAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BalanceSyncedAt that)) return false;
		return this.syncedAt.equals(that.syncedAt);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(syncedAt);
	}

	@Override
	public String toString() {
		return String.valueOf(syncedAt);
	}
}
