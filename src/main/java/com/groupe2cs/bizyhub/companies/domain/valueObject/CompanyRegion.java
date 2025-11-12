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
public class CompanyRegion implements Serializable {

	private String region;

	public CompanyRegion(String region) {
		this.region = region;
	}

	public static CompanyRegion create(String region) {

		return new CompanyRegion(region);
	}

	public String value() {
		return this.region;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CompanyRegion that)) return false;
		return this.region.equals(that.region);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(region);
	}

	@Override
	public String toString() {
		return String.valueOf(region);
	}
}
