package com.groupe2cs.bizyhub.sync.domain.valueObject;

import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateIdNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class SyncStateId implements Serializable {

	private String id;

	public SyncStateId(String id) {
		this.id = id;
	}

	public static SyncStateId create(String id) {

		if (id == null || id.isBlank()) {
			throw new SyncStateIdNotValid("Id is invalid");
		}
		return new SyncStateId(id);
	}

	public String value() {
		return this.id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SyncStateId that)) return false;
		return this.id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(id);
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
