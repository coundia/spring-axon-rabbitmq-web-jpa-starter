package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemQuantityNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionItemQuantity implements Serializable {

	private Integer quantity;

	public TransactionItemQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public static TransactionItemQuantity create(Integer quantity) {

		if (quantity < 0) {
			throw new TransactionItemQuantityNotValid("Quantity is invalid");
		}
		return new TransactionItemQuantity(quantity);
	}

	public Integer value() {
		return this.quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionItemQuantity that)) return false;
		return this.quantity.equals(that.quantity);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(quantity);
	}

	@Override
	public String toString() {
		return String.valueOf(quantity);
	}
}
