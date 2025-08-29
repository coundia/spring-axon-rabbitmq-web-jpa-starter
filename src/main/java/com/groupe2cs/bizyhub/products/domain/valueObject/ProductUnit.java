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
public class ProductUnit implements Serializable {

	private String unit;

	public ProductUnit(String unit) {
		this.unit = unit;
	}

	public static ProductUnit create(String unit) {

		return new ProductUnit(unit);
	}

	public String value() {
		return this.unit;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProductUnit that)) return false;
		return this.unit.equals(that.unit);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(unit);
	}

	@Override
	public String toString() {
		return String.valueOf(unit);
	}
}
