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
public class CompanyIsPublic implements Serializable {

	private Boolean isPublic;

	public CompanyIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public static CompanyIsPublic create(Boolean isPublic) {

		return new CompanyIsPublic(isPublic);
	}

	public Boolean value() {
		return this.isPublic;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CompanyIsPublic that)) return false;
		return this.isPublic.equals(that.isPublic);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isPublic);
	}

	@Override
	public String toString() {
		return String.valueOf(isPublic);
	}
}
