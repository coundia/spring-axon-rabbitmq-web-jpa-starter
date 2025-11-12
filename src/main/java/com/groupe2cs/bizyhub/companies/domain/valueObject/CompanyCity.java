package com.groupe2cs.bizyhub.companies.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CompanyCity implements Serializable {

	private String city;

	public CompanyCity(String city) {
		this.city = city;
	}

	public static CompanyCity create(String city) {

		return new CompanyCity(city);
	}

	public String value() {
		return this.city;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CompanyCity that)) return false;
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
