package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIsExcluToRapportNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionIsExcluToRapport implements Serializable {

	private Boolean isExcluToRapport;

	public TransactionIsExcluToRapport(Boolean isExcluToRapport) {
		this.isExcluToRapport = isExcluToRapport;
	}

	public static TransactionIsExcluToRapport create(Boolean isExcluToRapport) {
		if (isExcluToRapport == null) {
			throw new TransactionIsExcluToRapportNotValid("IsExcluToRapport is invalid");
		}
		return new TransactionIsExcluToRapport(isExcluToRapport);
	}

	public Boolean value() {
		return this.isExcluToRapport;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TransactionIsExcluToRapport that)) return false;
		return this.isExcluToRapport.equals(that.isExcluToRapport);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isExcluToRapport);
	}

	@Override
	public String toString() {
		return String.valueOf(isExcluToRapport);
	}
}
