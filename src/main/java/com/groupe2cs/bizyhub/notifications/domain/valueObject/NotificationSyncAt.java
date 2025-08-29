package com.groupe2cs.bizyhub.notifications.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class NotificationSyncAt implements Serializable {

	private java.time.Instant syncAt;

	public NotificationSyncAt(java.time.Instant syncAt) {
		this.syncAt = syncAt;
	}

	public static NotificationSyncAt create(java.time.Instant syncAt) {

		return new NotificationSyncAt(syncAt);
	}

	public java.time.Instant value() {
		return this.syncAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof NotificationSyncAt that)) return false;
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
