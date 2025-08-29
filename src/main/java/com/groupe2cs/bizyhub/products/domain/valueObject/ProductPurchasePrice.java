package com.groupe2cs.bizyhub.products.domain.valueObject;

import com.groupe2cs.bizyhub.products.domain.exception.ProductPurchasePriceNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ProductPurchasePrice implements Serializable {

	private Double purchasePrice;

	public ProductPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public static ProductPurchasePrice create(Double purchasePrice) {

		if (purchasePrice == null) {
			throw new ProductPurchasePriceNotValid("PurchasePrice is invalid");
		}
		return new ProductPurchasePrice(purchasePrice);
	}

	public Double value() {
		return this.purchasePrice;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProductPurchasePrice that)) return false;
		return this.purchasePrice.equals(that.purchasePrice);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(purchasePrice);
	}

	@Override
	public String toString() {
		return String.valueOf(purchasePrice);
	}
}
