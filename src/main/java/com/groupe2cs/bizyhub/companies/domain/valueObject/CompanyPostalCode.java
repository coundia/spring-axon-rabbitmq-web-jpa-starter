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
public class CompanyPostalCode implements Serializable {

	private String postalCode;

	public CompanyPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public static CompanyPostalCode create(String postalCode) {

		return new CompanyPostalCode(postalCode);
	}

	public String value() {
		return this.postalCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CompanyPostalCode that)) return false;
		return this.postalCode.equals(that.postalCode);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(postalCode);
	}

	@Override
	public String toString() {
		return String.valueOf(postalCode);
	}
}
