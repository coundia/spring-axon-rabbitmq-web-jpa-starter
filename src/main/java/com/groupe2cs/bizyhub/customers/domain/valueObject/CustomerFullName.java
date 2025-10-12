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
public class CustomerFullName implements Serializable {

	private String fullName;

	public CustomerFullName(String fullName) {
		this.fullName = fullName;
	}

	public static CustomerFullName create(String fullName) {

		return new CustomerFullName(fullName);
	}

	public String value() {
		return this.fullName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CustomerFullName that)) return false;
		return this.fullName.equals(that.fullName);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(fullName);
	}

	@Override
	public String toString() {
		return String.valueOf(fullName);
	}
}
