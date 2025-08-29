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
public class TransactionEntityId implements Serializable {

	private String entityId;

	public TransactionEntityId(String entityId) {
		this.entityId = entityId;
	}

	public static TransactionEntityId create(String entityId) {

		return new TransactionEntityId(entityId);
	}

	public String value() {
		return this.entityId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionEntityId that)) return false;
		return this.entityId.equals(that.entityId);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(entityId);
	}

	@Override
	public String toString() {
		return String.valueOf(entityId);
	}
}
