package com.groupe2cs.bizyhub.customers.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CustomerCode implements Serializable {

	private String code;

	public CustomerCode(String code) {
		this.code = code;
	}

	public static CustomerCode create(String code) {

		return new CustomerCode(code);
	}

	public String value() {
		return this.code;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CustomerCode that)) return false;
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
