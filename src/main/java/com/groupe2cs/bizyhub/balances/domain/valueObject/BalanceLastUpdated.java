package com.groupe2cs.bizyhub.balances.domain.valueObject;

import com.groupe2cs.bizyhub.balances.domain.exception.BalanceLastUpdatedNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class BalanceLastUpdated implements Serializable {

	private java.time.Instant lastUpdated;

	public BalanceLastUpdated(java.time.Instant lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public static BalanceLastUpdated create(java.time.Instant lastUpdated) {
		if (lastUpdated == null) {
			throw new BalanceLastUpdatedNotValid("LastUpdated is invalid");
		}
		return new BalanceLastUpdated(lastUpdated);
	}

	public java.time.Instant value() {
		return this.lastUpdated;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BalanceLastUpdated that)) return false;
		return this.lastUpdated.equals(that.lastUpdated);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(lastUpdated);
	}

	@Override
	public String toString() {
		return String.valueOf(lastUpdated);
	}
}
