package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionNameNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionName implements Serializable {

	private String name;

	public TransactionName(String name) {
		this.name = name;
	}

	public static TransactionName create(String name) {

		if (name == null || name.isBlank()) {
			throw new TransactionNameNotValid("Name is invalid");
		}
		return new TransactionName(name);
	}

	public String value() {
		return this.name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionName that)) return false;
		return this.name.equals(that.name);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(name);
	}

	@Override
	public String toString() {
		return String.valueOf(name);
	}
}
