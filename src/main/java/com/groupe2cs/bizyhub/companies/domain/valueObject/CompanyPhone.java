package com.groupe2cs.bizyhub.companies.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CompanyPhone implements Serializable {

	private String phone;

	public CompanyPhone(String phone) {
		this.phone = phone;
	}

	public static CompanyPhone create(String phone) {

		return new CompanyPhone(phone);
	}

	public String value() {
		return this.phone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CompanyPhone that)) return false;
		return this.phone.equals(that.phone);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(phone);
	}

	@Override
	public String toString() {
		return String.valueOf(phone);
	}
}
