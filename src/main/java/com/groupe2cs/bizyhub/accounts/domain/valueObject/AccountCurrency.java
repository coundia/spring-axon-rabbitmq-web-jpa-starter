package com.groupe2cs.bizyhub.accounts.domain.valueObject;

import com.groupe2cs.bizyhub.accounts.domain.exception.AccountCurrencyNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class AccountCurrency implements Serializable {

	private String currency;

	public AccountCurrency(String currency) {
		this.currency = currency;
	}

	public static AccountCurrency create(String currency) {

		if (currency == null || currency.isBlank()) {
			throw new AccountCurrencyNotValid("Currency is invalid");
		}
		return new AccountCurrency(currency);
	}

	public String value() {
		return this.currency;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountCurrency that)) return false;
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
