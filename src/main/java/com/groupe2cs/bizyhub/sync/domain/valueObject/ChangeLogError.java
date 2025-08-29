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
public class ChangeLogError implements Serializable {

	private String error;

	public ChangeLogError(String error) {
		this.error = error;
	}

	public static ChangeLogError create(String error) {

		return new ChangeLogError(error);
	}

	public String value() {
		return this.error;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ChangeLogError that)) return false;
		return this.error.equals(that.error);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(error);
	}

	@Override
	public String toString() {
		return String.valueOf(error);
	}
}
