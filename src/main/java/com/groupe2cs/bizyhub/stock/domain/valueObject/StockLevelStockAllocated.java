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
public class StockLevelStockAllocated implements Serializable {

	private Integer stockAllocated;

	public StockLevelStockAllocated(Integer stockAllocated) {
		this.stockAllocated = stockAllocated;
	}

	public static StockLevelStockAllocated create(Integer stockAllocated) {

		return new StockLevelStockAllocated(stockAllocated);
	}

	public Integer value() {
		return this.stockAllocated;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof StockLevelStockAllocated that)) return false;
		return this.stockAllocated.equals(that.stockAllocated);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(stockAllocated);
	}

	@Override
	public String toString() {
		return String.valueOf(stockAllocated);
	}
}
