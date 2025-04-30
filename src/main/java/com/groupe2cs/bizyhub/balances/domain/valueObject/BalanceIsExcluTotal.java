package com.groupe2cs.bizyhub.balances.domain.valueObject;

import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIsExcluTotalNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class BalanceIsExcluTotal implements Serializable {

	private Boolean isExcluTotal;

	public BalanceIsExcluTotal(Boolean isExcluTotal) {
		this.isExcluTotal = isExcluTotal;
	}

	public static BalanceIsExcluTotal create(Boolean isExcluTotal) {
		if (isExcluTotal == null) {
			throw new BalanceIsExcluTotalNotValid("IsExcluTotal is invalid");
		}
		return new BalanceIsExcluTotal(isExcluTotal);
	}

	public Boolean value() {
		return this.isExcluTotal;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BalanceIsExcluTotal that)) return false;
		return this.isExcluTotal.equals(that.isExcluTotal);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isExcluTotal);
	}

	@Override
	public String toString() {
		return String.valueOf(isExcluTotal);
	}
}
