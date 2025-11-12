package com.groupe2cs.bizyhub.products.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ProductHasPrice implements Serializable {

	private Boolean hasPrice;

	public ProductHasPrice(Boolean hasPrice) {
		this.hasPrice = hasPrice;
	}

	public static ProductHasPrice create(Boolean hasPrice) {

		return new ProductHasPrice(hasPrice);
	}

	public Boolean value() {
		return this.hasPrice;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProductHasPrice that)) return false;
		return this.hasPrice.equals(that.hasPrice);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(hasPrice);
	}

	@Override
	public String toString() {
		return String.valueOf(hasPrice);
	}
}
