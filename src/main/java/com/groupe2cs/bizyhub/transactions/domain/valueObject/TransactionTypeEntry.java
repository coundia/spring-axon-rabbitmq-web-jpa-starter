package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionTypeEntryNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionTypeEntry implements Serializable {

	private String typeEntry;

	public TransactionTypeEntry(String typeEntry) {
		this.typeEntry = typeEntry;
	}

	public static TransactionTypeEntry create(String typeEntry) {

		if (typeEntry == null || typeEntry.isBlank()) {
			throw new TransactionTypeEntryNotValid("TypeEntry is invalid");
		}
		return new TransactionTypeEntry(typeEntry);
	}

	public String value() {
		return this.typeEntry;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionTypeEntry that)) return false;
		return this.typeEntry.equals(that.typeEntry);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(typeEntry);
	}

	@Override
	public String toString() {
		return String.valueOf(typeEntry);
	}
}
