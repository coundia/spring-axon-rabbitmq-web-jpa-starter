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
public class ChangeLogPayload implements Serializable {

	private String payload;

	public ChangeLogPayload(String payload) {
		this.payload = payload;
	}

	public static ChangeLogPayload create(String payload) {

		return new ChangeLogPayload(payload);
	}

	public String value() {
		return this.payload;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ChangeLogPayload that)) return false;
		return this.payload.equals(that.payload);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(payload);
	}

	@Override
	public String toString() {
		return String.valueOf(payload);
	}
}
