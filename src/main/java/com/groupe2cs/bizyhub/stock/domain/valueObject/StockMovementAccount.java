package com.groupe2cs.bizyhub.stock.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class StockMovementAccount implements Serializable {

	private String account;

	public StockMovementAccount(String account) {
		this.account = account;
	}

	public static StockMovementAccount create(String account) {

		return new StockMovementAccount(account);
	}

	public String value() {
		return this.account;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof StockMovementAccount that)) return false;
		return this.account.equals(that.account);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(account);
	}

	@Override
	public String toString() {
		return String.valueOf(account);
	}
}
