package com.groupe2cs.bizyhub.debts.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class DebtIsActive implements Serializable {

	private Boolean isActive;

	public DebtIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public static DebtIsActive create(Boolean isActive) {

		return new DebtIsActive(isActive);
	}

	public Boolean value() {
		return this.isActive;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DebtIsActive that)) return false;
		return this.isActive.equals(that.isActive);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isActive);
	}

	@Override
	public String toString() {
		return String.valueOf(isActive);
	}
}
