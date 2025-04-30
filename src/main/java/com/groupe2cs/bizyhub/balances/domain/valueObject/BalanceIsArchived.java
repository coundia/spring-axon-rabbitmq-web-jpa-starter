package com.groupe2cs.bizyhub.balances.domain.valueObject;

import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIsArchivedNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class BalanceIsArchived implements Serializable {

	private Boolean isArchived;

	public BalanceIsArchived(Boolean isArchived) {
		this.isArchived = isArchived;
	}

	public static BalanceIsArchived create(Boolean isArchived) {
		if (isArchived == null) {
			throw new BalanceIsArchivedNotValid("IsArchived is invalid");
		}
		return new BalanceIsArchived(isArchived);
	}

	public Boolean value() {
		return this.isArchived;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BalanceIsArchived that)) return false;
		return this.isArchived.equals(that.isArchived);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isArchived);
	}

	@Override
	public String toString() {
		return String.valueOf(isArchived);
	}
}
