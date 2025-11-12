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
public class ProductHasSold implements Serializable {

	private Boolean hasSold;

	public ProductHasSold(Boolean hasSold) {
		this.hasSold = hasSold;
	}

	public static ProductHasSold create(Boolean hasSold) {

		return new ProductHasSold(hasSold);
	}

	public Boolean value() {
		return this.hasSold;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProductHasSold that)) return false;
		return this.hasSold.equals(that.hasSold);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(hasSold);
	}

	@Override
	public String toString() {
		return String.valueOf(hasSold);
	}
}
