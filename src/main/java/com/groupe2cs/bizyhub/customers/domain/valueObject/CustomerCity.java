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
public class CustomerCity implements Serializable {

	private String city;

	public CustomerCity(String city) {
		this.city = city;
	}

	public static CustomerCity create(String city) {

		return new CustomerCity(city);
	}

	public String value() {
		return this.city;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CustomerCity that)) return false;
		return this.city.equals(that.city);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(city);
	}

	@Override
	public String toString() {
		return String.valueOf(city);
	}
}
