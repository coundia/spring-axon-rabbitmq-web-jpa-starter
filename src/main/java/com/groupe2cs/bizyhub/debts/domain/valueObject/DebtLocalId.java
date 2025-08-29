package com.groupe2cs.bizyhub.debts.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class DebtLocalId implements Serializable {

	private String localId;

	public DebtLocalId(String localId) {
		this.localId = localId;
	}

	public static DebtLocalId create(String localId) {

		return new DebtLocalId(localId);
	}

	public String value() {
		return this.localId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DebtLocalId that)) return false;
		return this.localId.equals(that.localId);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(localId);
	}

	@Override
	public String toString() {
		return String.valueOf(localId);
	}
}
