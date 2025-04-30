package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDescriptionNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionDescription implements Serializable {

	private String description;

	public TransactionDescription(String description) {
		this.description = description;
	}

	public static TransactionDescription create(String description) {
		if (description == null || description.isBlank()) {
			throw new TransactionDescriptionNotValid("Description is invalid");
		}
		return new TransactionDescription(description);
	}

	public String value() {
		return this.description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionDescription that)) return false;
		return this.description.equals(that.description);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(description);
	}

	@Override
	public String toString() {
		return String.valueOf(description);
	}
}
