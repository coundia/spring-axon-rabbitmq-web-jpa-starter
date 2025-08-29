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
public class DebtCode implements Serializable {

	private String code;

	public DebtCode(String code) {
		this.code = code;
	}

	public static DebtCode create(String code) {

		return new DebtCode(code);
	}

	public String value() {
		return this.code;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DebtCode that)) return false;
		return this.code.equals(that.code);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(code);
	}

	@Override
	public String toString() {
		return String.valueOf(code);
	}
}
