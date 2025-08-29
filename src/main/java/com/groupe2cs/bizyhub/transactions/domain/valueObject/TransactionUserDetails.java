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
public class TransactionUserDetails implements Serializable {

	private String details;

	public TransactionUserDetails(String details) {
		this.details = details;
	}

	public static TransactionUserDetails create(String details) {

		return new TransactionUserDetails(details);
	}

	public String value() {
		return this.details;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionUserDetails that)) return false;
		return this.details.equals(that.details);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(details);
	}

	@Override
	public String toString() {
		return String.valueOf(details);
	}
}
