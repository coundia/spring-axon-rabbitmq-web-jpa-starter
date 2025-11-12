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
public class CompanyTaxId implements Serializable {

	private String taxId;

	public CompanyTaxId(String taxId) {
		this.taxId = taxId;
	}

	public static CompanyTaxId create(String taxId) {

		return new CompanyTaxId(taxId);
	}

	public String value() {
		return this.taxId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CompanyTaxId that)) return false;
		return this.taxId.equals(that.taxId);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(taxId);
	}

	@Override
	public String toString() {
		return String.valueOf(taxId);
	}
}
