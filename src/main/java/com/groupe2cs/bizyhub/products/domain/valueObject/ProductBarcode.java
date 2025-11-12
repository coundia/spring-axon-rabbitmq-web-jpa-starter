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
public class ProductBarcode implements Serializable {

	private String barcode;

	public ProductBarcode(String barcode) {
		this.barcode = barcode;
	}

	public static ProductBarcode create(String barcode) {

		return new ProductBarcode(barcode);
	}

	public String value() {
		return this.barcode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProductBarcode that)) return false;
		return this.barcode.equals(that.barcode);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(barcode);
	}

	@Override
	public String toString() {
		return String.valueOf(barcode);
	}
}
