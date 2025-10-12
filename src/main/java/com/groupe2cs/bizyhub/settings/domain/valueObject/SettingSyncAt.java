package com.groupe2cs.bizyhub.settings.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class SettingSyncAt implements Serializable {

	private java.time.Instant syncAt;

	public SettingSyncAt(java.time.Instant syncAt) {
		this.syncAt = syncAt;
	}

	public static SettingSyncAt create(java.time.Instant syncAt) {

		return new SettingSyncAt(syncAt);
	}

	public java.time.Instant value() {
		return this.syncAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SettingSyncAt that)) return false;
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
