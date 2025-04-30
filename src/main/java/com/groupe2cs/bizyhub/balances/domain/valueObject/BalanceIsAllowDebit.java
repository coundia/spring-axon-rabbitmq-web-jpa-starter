package com.groupe2cs.bizyhub.balances.domain.valueObject;

import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIsAllowDebitNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class BalanceIsAllowDebit implements Serializable {

	private Boolean isAllowDebit;

	public BalanceIsAllowDebit(Boolean isAllowDebit) {
		this.isAllowDebit = isAllowDebit;
	}

	public static BalanceIsAllowDebit create(Boolean isAllowDebit) {
		if (isAllowDebit == null) {
			throw new BalanceIsAllowDebitNotValid("IsAllowDebit is invalid");
		}
		return new BalanceIsAllowDebit(isAllowDebit);
	}

	public Boolean value() {
		return this.isAllowDebit;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BalanceIsAllowDebit that)) return false;
		return this.isAllowDebit.equals(that.isAllowDebit);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isAllowDebit);
	}

	@Override
	public String toString() {
		return String.valueOf(isAllowDebit);
	}
}
