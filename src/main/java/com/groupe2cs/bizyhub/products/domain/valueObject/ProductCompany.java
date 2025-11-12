package com.groupe2cs.bizyhub.products.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ProductCompany implements Serializable {

	private String company;

	public ProductCompany(String company) {
		this.company = company;
	}

	public static ProductCompany create(String company) {

		return new ProductCompany(company);
	}

	public String value() {
		return this.company;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProductCompany that)) return false;
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
