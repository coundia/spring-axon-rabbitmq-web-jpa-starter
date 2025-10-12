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
public class TransactionItemLabel implements Serializable {

	private String label;

	public TransactionItemLabel(String label) {
		this.label = label;
	}

	public static TransactionItemLabel create(String label) {

		return new TransactionItemLabel(label);
	}

	public String value() {
		return this.label;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionItemLabel that)) return false;
		return this.label.equals(that.label);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(label);
	}

	@Override
	public String toString() {
		return String.valueOf(label);
	}
}
