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
public class ProductStatuses implements Serializable {

	private String statuses;

	public ProductStatuses(String statuses) {
		this.statuses = statuses;
	}

	public static ProductStatuses create(String statuses) {

		return new ProductStatuses(statuses);
	}

	public String value() {
		return this.statuses;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProductStatuses that)) return false;
		return this.statuses.equals(that.statuses);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(statuses);
	}

	@Override
	public String toString() {
		return String.valueOf(statuses);
	}
}
