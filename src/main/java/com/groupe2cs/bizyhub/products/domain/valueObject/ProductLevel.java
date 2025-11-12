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
public class ProductLevel implements Serializable {

	private String level;

	public ProductLevel(String level) {
		this.level = level;
	}

	public static ProductLevel create(String level) {

		return new ProductLevel(level);
	}

	public String value() {
		return this.level;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProductLevel that)) return false;
		return this.level.equals(that.level);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(level);
	}

	@Override
	public String toString() {
		return String.valueOf(level);
	}
}
