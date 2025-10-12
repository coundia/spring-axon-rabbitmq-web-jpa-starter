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
public class DebtDueDate implements Serializable {

	private java.time.Instant dueDate;

	public DebtDueDate(java.time.Instant dueDate) {
		this.dueDate = dueDate;
	}

	public static DebtDueDate create(java.time.Instant dueDate) {

		return new DebtDueDate(dueDate);
	}

	public java.time.Instant value() {
		return this.dueDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DebtDueDate that)) return false;
		return this.dueDate.equals(that.dueDate);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(dueDate);
	}

	@Override
	public String toString() {
		return String.valueOf(dueDate);
	}
}
