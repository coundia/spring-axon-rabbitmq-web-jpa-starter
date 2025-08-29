package com.groupe2cs.bizyhub.companies.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CompanyCurrency implements Serializable {

	private String currency;

	public CompanyCurrency(String currency) {
		this.currency = currency;
	}

	public static CompanyCurrency create(String currency) {

		return new CompanyCurrency(currency);
	}

	public String value() {
		return this.currency;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CompanyCurrency that)) return false;
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
