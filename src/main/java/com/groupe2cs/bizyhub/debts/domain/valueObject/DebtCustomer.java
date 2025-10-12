package com.groupe2cs.bizyhub.debts.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class DebtCustomer implements Serializable {

	private String customer;

	public DebtCustomer(String customer) {
		this.customer = customer;
	}

	public static DebtCustomer create(String customer) {

		return new DebtCustomer(customer);
	}

	public String value() {
		return this.customer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DebtCustomer that)) return false;
		return this.customer.equals(that.customer);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(customer);
	}

	@Override
	public String toString() {
		return String.valueOf(customer);
	}
}
