package com.groupe2cs.bizyhub.customers.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CustomerRegion implements Serializable {

	private String region;

	public CustomerRegion(String region) {
		this.region = region;
	}

	public static CustomerRegion create(String region) {

		return new CustomerRegion(region);
	}

	public String value() {
		return this.region;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CustomerRegion that)) return false;
		return this.region.equals(that.region);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(region);
	}

	@Override
	public String toString() {
		return String.valueOf(region);
	}
}
