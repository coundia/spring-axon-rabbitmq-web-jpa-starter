package com.groupe2cs.bizyhub.companies.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.companies.domain.exception.CompanyIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyRemoteIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyLocalIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyCodeNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyNameNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyDescriptionNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyPhoneNotValid;

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
