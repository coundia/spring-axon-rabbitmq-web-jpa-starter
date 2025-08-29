package com.groupe2cs.bizyhub.stock.domain.valueObject;

import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementQuantityNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class StockMovementQuantity implements Serializable {

	private Integer quantity;

	public StockMovementQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public static StockMovementQuantity create(Integer quantity) {

		if (quantity < 0) {
			throw new StockMovementQuantityNotValid("Quantity is invalid");
		}
		return new StockMovementQuantity(quantity);
	}

	public Integer value() {
		return this.quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof StockMovementQuantity that)) return false;
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
