package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionCustomer implements Serializable {

	private String customer;

	public TransactionCustomer(String customer) {
		this.customer = customer;
	}

	public static TransactionCustomer create(String customer) {

		return new TransactionCustomer(customer);
	}

	public String value() {
		return this.customer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionCustomer that)) return false;
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
