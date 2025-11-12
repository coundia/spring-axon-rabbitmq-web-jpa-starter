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
public class ProductStatus implements Serializable {

	private String status;

	public ProductStatus(String status) {
		this.status = status;
	}

	public static ProductStatus create(String status) {

		return new ProductStatus(status);
	}

	public String value() {
		return this.status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProductStatus that)) return false;
		return this.status.equals(that.status);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(status);
	}

	@Override
	public String toString() {
		return String.valueOf(status);
	}
}
