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
public class TransactionEntityName implements Serializable {

	private String entityName;

	public TransactionEntityName(String entityName) {
		this.entityName = entityName;
	}

	public static TransactionEntityName create(String entityName) {

		return new TransactionEntityName(entityName);
	}

	public String value() {
		return this.entityName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionEntityName that)) return false;
		return this.entityName.equals(that.entityName);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(entityName);
	}

	@Override
	public String toString() {
		return String.valueOf(entityName);
	}
}
