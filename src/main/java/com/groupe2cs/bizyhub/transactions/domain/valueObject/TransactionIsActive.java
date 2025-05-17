package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIsActiveNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionIsActive implements Serializable {

	private Boolean isActive;

	public TransactionIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public static TransactionIsActive create(Boolean isActive) {

		if (isActive == null) {
			throw new TransactionIsActiveNotValid("IsActive is invalid");
		}
		return new TransactionIsActive(isActive);
	}

	public Boolean value() {
		return this.isActive;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionIsActive that)) return false;
		return this.isActive.equals(that.isActive);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isActive);
	}

	@Override
	public String toString() {
		return String.valueOf(isActive);
	}
}
