package com.groupe2cs.bizyhub.companies.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.companies.domain.exception.CompanyIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyRemoteIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyLocalIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyCodeNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyNameNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyDescriptionNotValid;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CompanyDescription implements Serializable {

	private String description;

	public CompanyDescription(String description) {
		this.description = description;
	}

	public static CompanyDescription create(String description) {

		return new CompanyDescription(description);
	}

	public String value() {
		return this.description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CompanyDescription that)) return false;
		return this.description.equals(that.description);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(description);
	}

	@Override
	public String toString() {
		return String.valueOf(description);
	}
}
