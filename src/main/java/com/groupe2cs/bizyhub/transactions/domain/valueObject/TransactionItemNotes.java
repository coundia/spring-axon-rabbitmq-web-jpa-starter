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
public class TransactionItemNotes implements Serializable {

	private String notes;

	public TransactionItemNotes(String notes) {
		this.notes = notes;
	}

	public static TransactionItemNotes create(String notes) {

		return new TransactionItemNotes(notes);
	}

	public String value() {
		return this.notes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionItemNotes that)) return false;
		return this.notes.equals(that.notes);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(notes);
	}

	@Override
	public String toString() {
		return String.valueOf(notes);
	}
}
