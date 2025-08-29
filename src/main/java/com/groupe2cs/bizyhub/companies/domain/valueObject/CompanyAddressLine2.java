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
public class CompanyAddressLine2 implements Serializable {

	private String addressLine2;

	public CompanyAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public static CompanyAddressLine2 create(String addressLine2) {

		return new CompanyAddressLine2(addressLine2);
	}

	public String value() {
		return this.addressLine2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CompanyAddressLine2 that)) return false;
		return this.addressLine2.equals(that.addressLine2);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(addressLine2);
	}

	@Override
	public String toString() {
		return String.valueOf(addressLine2);
	}
}
