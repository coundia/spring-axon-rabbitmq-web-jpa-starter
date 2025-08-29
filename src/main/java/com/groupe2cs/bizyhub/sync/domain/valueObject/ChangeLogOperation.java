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
public class ChangeLogOperation implements Serializable {

	private String operation;

	public ChangeLogOperation(String operation) {
		this.operation = operation;
	}

	public static ChangeLogOperation create(String operation) {

		return new ChangeLogOperation(operation);
	}

	public String value() {
		return this.operation;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ChangeLogOperation that)) return false;
		return this.operation.equals(that.operation);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(operation);
	}

	@Override
	public String toString() {
		return String.valueOf(operation);
	}
}
