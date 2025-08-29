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
public class TransactionItemUnit implements Serializable {

	private String unit;

	public TransactionItemUnit(String unit) {
		this.unit = unit;
	}

	public static TransactionItemUnit create(String unit) {

		return new TransactionItemUnit(unit);
	}

	public String value() {
		return this.unit;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionItemUnit that)) return false;
		return this.unit.equals(that.unit);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(unit);
	}

	@Override
	public String toString() {
		return String.valueOf(unit);
	}
}
