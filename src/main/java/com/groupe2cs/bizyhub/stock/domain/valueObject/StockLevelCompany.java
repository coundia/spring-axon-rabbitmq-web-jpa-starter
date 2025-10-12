package com.groupe2cs.bizyhub.stock.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class StockLevelCompany implements Serializable {

	private String company;

	public StockLevelCompany(String company) {
		this.company = company;
	}

	public static StockLevelCompany create(String company) {

		return new StockLevelCompany(company);
	}

	public String value() {
		return this.company;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof StockLevelCompany that)) return false;
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
