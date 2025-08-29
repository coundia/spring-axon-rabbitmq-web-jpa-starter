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
public class CustomerCompany implements Serializable {

	private String company;

	public CustomerCompany(String company) {
		this.company = company;
	}

	public static CustomerCompany create(String company) {

		return new CustomerCompany(company);
	}

	public String value() {
		return this.company;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CustomerCompany that)) return false;
		return this.company.equals(that.company);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(company);
	}

	@Override
	public String toString() {
		return String.valueOf(company);
	}
}
