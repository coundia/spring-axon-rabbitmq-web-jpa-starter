package com.groupe2cs.bizyhub.debts.domain.valueObject;

import com.groupe2cs.bizyhub.debts.domain.exception.DebtIdNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class DebtId implements Serializable {

	private String id;

	public DebtId(String id) {
		this.id = id;
	}

	public static DebtId create(String id) {

		if (id == null || id.isBlank()) {
			throw new DebtIdNotValid("Id is invalid");
		}
		return new DebtId(id);
	}

	public String value() {
		return this.id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DebtId that)) return false;
		return this.id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(id);
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
