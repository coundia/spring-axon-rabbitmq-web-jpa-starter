package com.groupe2cs.bizyhub.products.domain.valueObject;

import com.groupe2cs.bizyhub.products.domain.exception.ProductDefaultPriceNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ProductDefaultPrice implements Serializable {

	private Double defaultPrice;

	public ProductDefaultPrice(Double defaultPrice) {
		this.defaultPrice = defaultPrice;
	}

	public static ProductDefaultPrice create(Double defaultPrice) {

		if (defaultPrice == null) {
			throw new ProductDefaultPriceNotValid("DefaultPrice is invalid");
		}
		return new ProductDefaultPrice(defaultPrice);
	}

	public Double value() {
		return this.defaultPrice;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProductDefaultPrice that)) return false;
		return this.defaultPrice.equals(that.defaultPrice);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(defaultPrice);
	}

	@Override
	public String toString() {
		return String.valueOf(defaultPrice);
	}
}
