package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTotalNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionItemTotal implements Serializable {

	private Double total;

	public TransactionItemTotal(Double total) {
		this.total = total;
	}

	public static TransactionItemTotal create(Double total) {

		if (total == null) {
			throw new TransactionItemTotalNotValid("Total is invalid");
		}
		return new TransactionItemTotal(total);
	}

	public Double value() {
		return this.total;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionItemTotal that)) return false;
		return this.total.equals(that.total);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(total);
	}

	@Override
	public String toString() {
		return String.valueOf(total);
	}
}
