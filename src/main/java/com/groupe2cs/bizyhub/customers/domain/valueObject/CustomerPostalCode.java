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
public class CustomerPostalCode implements Serializable {

	private String postalCode;

	public CustomerPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public static CustomerPostalCode create(String postalCode) {

		return new CustomerPostalCode(postalCode);
	}

	public String value() {
		return this.postalCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CustomerPostalCode that)) return false;
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
