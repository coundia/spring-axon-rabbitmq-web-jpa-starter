package com.groupe2cs.bizyhub.stock.domain.valueObject;

import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementTypeStockMovementNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class StockMovementTypeStockMovement implements Serializable {

	private String typeStockMovement;

	public StockMovementTypeStockMovement(String typeStockMovement) {
		this.typeStockMovement = typeStockMovement;
	}

	public static StockMovementTypeStockMovement create(String typeStockMovement) {

		if (typeStockMovement == null || typeStockMovement.isBlank()) {
			throw new StockMovementTypeStockMovementNotValid("TypeStockMovement is invalid");
		}
		return new StockMovementTypeStockMovement(typeStockMovement);
	}

	public String value() {
		return this.typeStockMovement;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof StockMovementTypeStockMovement that)) return false;
		return this.typeStockMovement.equals(that.typeStockMovement);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(typeStockMovement);
	}

	@Override
	public String toString() {
		return String.valueOf(typeStockMovement);
	}
}
