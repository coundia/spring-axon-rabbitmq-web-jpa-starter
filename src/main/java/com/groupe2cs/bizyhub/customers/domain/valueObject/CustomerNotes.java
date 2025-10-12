package com.groupe2cs.bizyhub.customers.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CustomerNotes implements Serializable {

	private String notes;

	public CustomerNotes(String notes) {
		this.notes = notes;
	}

	public static CustomerNotes create(String notes) {

		return new CustomerNotes(notes);
	}

	public String value() {
		return this.notes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CustomerNotes that)) return false;
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
