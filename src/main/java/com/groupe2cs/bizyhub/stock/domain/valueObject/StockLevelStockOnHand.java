package com.groupe2cs.bizyhub.stock.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class StockLevelStockOnHand implements Serializable {

	private Integer stockOnHand;

	public StockLevelStockOnHand(Integer stockOnHand) {
		this.stockOnHand = stockOnHand;
	}

	public static StockLevelStockOnHand create(Integer stockOnHand) {

		return new StockLevelStockOnHand(stockOnHand);
	}

	public Integer value() {
		return this.stockOnHand;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof StockLevelStockOnHand that)) return false;
		return this.stockOnHand.equals(that.stockOnHand);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(stockOnHand);
	}

	@Override
	public String toString() {
		return String.valueOf(stockOnHand);
	}
}
