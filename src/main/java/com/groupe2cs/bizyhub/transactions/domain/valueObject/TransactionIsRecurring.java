package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIsRecurringNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionIsRecurring implements Serializable {

	private Boolean isRecurring;

	public TransactionIsRecurring(Boolean isRecurring) {
		this.isRecurring = isRecurring;
	}

	public static TransactionIsRecurring create(Boolean isRecurring) {
		if (isRecurring == null) {
			throw new TransactionIsRecurringNotValid("IsRecurring is invalid");
		}
		return new TransactionIsRecurring(isRecurring);
	}

	public Boolean value() {
		return this.isRecurring;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionIsRecurring that)) return false;
		return this.isRecurring.equals(that.isRecurring);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isRecurring);
	}

	@Override
	public String toString() {
		return String.valueOf(isRecurring);
	}
}
