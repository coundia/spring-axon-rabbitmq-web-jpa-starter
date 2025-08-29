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
public class StockLevelProductVariant implements Serializable {

	private String productVariant;

	public StockLevelProductVariant(String productVariant) {
		this.productVariant = productVariant;
	}

	public static StockLevelProductVariant create(String productVariant) {

		return new StockLevelProductVariant(productVariant);
	}

	public String value() {
		return this.productVariant;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof StockLevelProductVariant that)) return false;
		return this.productVariant.equals(that.productVariant);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(productVariant);
	}

	@Override
	public String toString() {
		return String.valueOf(productVariant);
	}
}
