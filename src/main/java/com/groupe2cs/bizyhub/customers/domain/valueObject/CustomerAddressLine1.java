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
public class CustomerAddressLine1 implements Serializable {

	private String addressLine1;

	public CustomerAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public static CustomerAddressLine1 create(String addressLine1) {

		return new CustomerAddressLine1(addressLine1);
	}

	public String value() {
		return this.addressLine1;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CustomerAddressLine1 that)) return false;
		return this.addressLine1.equals(that.addressLine1);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(addressLine1);
	}

	@Override
	public String toString() {
		return String.valueOf(addressLine1);
	}
}
