package com.groupe2cs.bizyhub.balances.domain.valueObject;

import com.groupe2cs.bizyhub.balances.domain.exception.BalanceOrdreNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class BalanceOrdre implements Serializable {

	private Integer ordre;

	public BalanceOrdre(Integer ordre) {
		this.ordre = ordre;
	}

	public static BalanceOrdre create(Integer ordre) {
		if (ordre < 0) {
			throw new BalanceOrdreNotValid("Ordre is invalid");
		}
		return new BalanceOrdre(ordre);
	}

	public Integer value() {
		return this.ordre;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BalanceOrdre that)) return false;
		return this.ordre.equals(that.ordre);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(ordre);
	}

	@Override
	public String toString() {
		return String.valueOf(ordre);
	}
}
