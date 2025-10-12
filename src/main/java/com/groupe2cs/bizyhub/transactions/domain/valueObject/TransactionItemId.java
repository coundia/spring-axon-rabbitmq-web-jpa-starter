package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemIdNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionItemId implements Serializable {

	private String id;

	public TransactionItemId(String id) {
		this.id = id;
	}

	public static TransactionItemId create(String id) {

		if (id == null || id.isBlank()) {
			throw new TransactionItemIdNotValid("Id is invalid");
		}
		return new TransactionItemId(id);
	}

	public String value() {
		return this.id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionItemId that)) return false;
		return this.id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(id);
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
