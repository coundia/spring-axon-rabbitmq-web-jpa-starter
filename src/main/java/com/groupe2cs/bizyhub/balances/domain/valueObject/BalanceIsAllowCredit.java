package com.groupe2cs.bizyhub.balances.domain.valueObject;

import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIsAllowCreditNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class BalanceIsAllowCredit implements Serializable {

	private Boolean isAllowCredit;

	public BalanceIsAllowCredit(Boolean isAllowCredit) {
		this.isAllowCredit = isAllowCredit;
	}

	public static BalanceIsAllowCredit create(Boolean isAllowCredit) {
		if (isAllowCredit == null) {
			throw new BalanceIsAllowCreditNotValid("IsAllowCredit is invalid");
		}
		return new BalanceIsAllowCredit(isAllowCredit);
	}

	public Boolean value() {
		return this.isAllowCredit;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BalanceIsAllowCredit that)) return false;
		return this.isAllowCredit.equals(that.isAllowCredit);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isAllowCredit);
	}

	@Override
	public String toString() {
		return String.valueOf(isAllowCredit);
	}
}
