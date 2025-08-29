package com.groupe2cs.bizyhub.sync.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class SyncStateLastCursor implements Serializable {

	private String lastCursor;

	public SyncStateLastCursor(String lastCursor) {
		this.lastCursor = lastCursor;
	}

	public static SyncStateLastCursor create(String lastCursor) {

		return new SyncStateLastCursor(lastCursor);
	}

	public String value() {
		return this.lastCursor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SyncStateLastCursor that)) return false;
		return this.lastCursor.equals(that.lastCursor);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(lastCursor);
	}

	@Override
	public String toString() {
		return String.valueOf(lastCursor);
	}
}
