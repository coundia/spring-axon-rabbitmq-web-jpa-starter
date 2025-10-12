package com.groupe2cs.bizyhub.sync.domain.valueObject;

import com.groupe2cs.bizyhub.sync.domain.exception.SyncStateEntityTableNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class SyncStateEntityTable implements Serializable {

	private String entityTable;

	public SyncStateEntityTable(String entityTable) {
		this.entityTable = entityTable;
	}

	public static SyncStateEntityTable create(String entityTable) {

		if (entityTable == null || entityTable.isBlank()) {
			throw new SyncStateEntityTableNotValid("EntityTable is invalid");
		}
		return new SyncStateEntityTable(entityTable);
	}

	public String value() {
		return this.entityTable;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SyncStateEntityTable that)) return false;
		return this.entityTable.equals(that.entityTable);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(entityTable);
	}

	@Override
	public String toString() {
		return String.valueOf(entityTable);
	}
}
