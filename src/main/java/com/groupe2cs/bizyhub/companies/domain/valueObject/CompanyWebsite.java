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
public class CompanyWebsite implements Serializable {

	private String website;

	public CompanyWebsite(String website) {
		this.website = website;
	}

	public static CompanyWebsite create(String website) {

		return new CompanyWebsite(website);
	}

	public String value() {
		return this.website;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CompanyWebsite that)) return false;
		return this.website.equals(that.website);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(website);
	}

	@Override
	public String toString() {
		return String.valueOf(website);
	}
}
