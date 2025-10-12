package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemUnitPriceNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionItemUnitPrice implements Serializable {

	private Double unitPrice;

	public TransactionItemUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public static TransactionItemUnitPrice create(Double unitPrice) {

		if (unitPrice == null) {
			throw new TransactionItemUnitPriceNotValid("UnitPrice is invalid");
		}
		return new TransactionItemUnitPrice(unitPrice);
	}

	public Double value() {
		return this.unitPrice;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionItemUnitPrice that)) return false;
		return this.unitPrice.equals(that.unitPrice);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(unitPrice);
	}

	@Override
	public String toString() {
		return String.valueOf(unitPrice);
	}
}
