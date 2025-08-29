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
public class DebtCreatedBy implements Serializable {

	private String createdBy;

	public DebtCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public static DebtCreatedBy create(String createdBy) {

		return new DebtCreatedBy(createdBy);
	}

	public String value() {
		return this.createdBy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DebtCreatedBy that)) return false;
		return this.createdBy.equals(that.createdBy);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(createdBy);
	}

	@Override
	public String toString() {
		return String.valueOf(createdBy);
	}
}
