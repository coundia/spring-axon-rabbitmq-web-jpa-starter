package com.groupe2cs.bizyhub.balances.domain.valueObject;

import com.groupe2cs.bizyhub.balances.domain.exception.BalanceCurrencyNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class BalanceCurrency implements Serializable {

	private String currency;

	public BalanceCurrency(String currency) {
		this.currency = currency;
	}

	public static BalanceCurrency create(String currency) {
		if (currency == null || currency.isBlank()) {
			throw new BalanceCurrencyNotValid("Currency is invalid");
		}
		return new BalanceCurrency(currency);
	}

	public String value() {
		return this.currency;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BalanceCurrency that)) return false;
		return this.currency.equals(that.currency);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(currency);
	}

	@Override
	public String toString() {
		return String.valueOf(currency);
	}
}
