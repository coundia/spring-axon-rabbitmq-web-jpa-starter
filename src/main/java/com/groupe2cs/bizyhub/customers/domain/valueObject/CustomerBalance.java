package com.groupe2cs.bizyhub.customers.domain.valueObject;

import com.groupe2cs.bizyhub.customers.domain.exception.CustomerBalanceNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CustomerBalance implements Serializable {

	private Double balance;

	public CustomerBalance(Double balance) {
		this.balance = balance;
	}

	public static CustomerBalance create(Double balance) {

		if (balance == null) {
			throw new CustomerBalanceNotValid("Balance is invalid");
		}
		return new CustomerBalance(balance);
	}

	public Double value() {
		return this.balance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CustomerBalance that)) return false;
		return this.balance.equals(that.balance);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(balance);
	}

	@Override
	public String toString() {
		return String.valueOf(balance);
	}
}
