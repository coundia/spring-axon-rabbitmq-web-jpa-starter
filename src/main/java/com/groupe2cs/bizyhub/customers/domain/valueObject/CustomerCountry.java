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
public class CustomerCountry implements Serializable {

	private String country;

	public CustomerCountry(String country) {
		this.country = country;
	}

	public static CustomerCountry create(String country) {

		return new CustomerCountry(country);
	}

	public String value() {
		return this.country;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CustomerCountry that)) return false;
		return this.country.equals(that.country);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(country);
	}

	@Override
	public String toString() {
		return String.valueOf(country);
	}
}
