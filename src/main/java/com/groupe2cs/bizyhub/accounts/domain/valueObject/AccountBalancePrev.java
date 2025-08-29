package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import com.groupe2cs.bizyhub.accounts.domain.exception.AccountBalancePrevNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class AccountBalancePrev implements Serializable {

	private Double balancePrev;

	public AccountBalancePrev(Double balancePrev) {
		this.balancePrev = balancePrev;
	}

	public static AccountBalancePrev create(Double balancePrev) {

		if (balancePrev == null) {
			throw new AccountBalancePrevNotValid("BalancePrev is invalid");
		}
		return new AccountBalancePrev(balancePrev);
	}

	public Double value() {
		return this.balancePrev;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountBalancePrev that)) return false;
		return this.balancePrev.equals(that.balancePrev);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(balancePrev);
	}

	@Override
	public String toString() {
		return String.valueOf(balancePrev);
	}
}
