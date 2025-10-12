package com.groupe2cs.bizyhub.tenant.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.tenant.domain.exception.TenantIdNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantNameNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantDescriptionNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantDomainNotValid;
import com.groupe2cs.bizyhub.tenant.domain.exception.TenantLanguageNotValid;

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
public class TenantLanguage implements Serializable {

	private String language;

	public TenantLanguage(String language) {
		this.language = language;
	}

	public static TenantLanguage create(String language) {

		return new TenantLanguage(language);
	}

	public String value() {
		return this.language;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TenantLanguage that)) return false;
		return this.language.equals(that.language);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(language);
	}

	@Override
	public String toString() {
		return String.valueOf(language);
	}
}
