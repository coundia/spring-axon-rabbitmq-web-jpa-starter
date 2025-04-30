package com.groupe2cs.bizyhub.balances.domain.valueObject;

import com.groupe2cs.bizyhub.balances.domain.exception.BalanceCreatedByNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class BalanceCreatedBy implements Serializable {

	private String createdBy;

	public BalanceCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public static BalanceCreatedBy create(String createdBy) {
		if (createdBy == null || createdBy.isBlank()) {
			throw new BalanceCreatedByNotValid("CreatedBy is invalid");
		}
		return new BalanceCreatedBy(createdBy);
	}

	public String value() {
		return this.createdBy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BalanceCreatedBy that)) return false;
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
