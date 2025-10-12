package com.groupe2cs.bizyhub.companies.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.companies.domain.exception.CompanyIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyRemoteIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyLocalIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyCodeNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyNameNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyDescriptionNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyPhoneNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyEmailNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyWebsiteNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyTaxIdNotValid;

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
