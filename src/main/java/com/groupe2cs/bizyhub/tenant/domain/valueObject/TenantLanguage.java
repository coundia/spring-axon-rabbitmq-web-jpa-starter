package com.groupe2cs.bizyhub.tenant.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

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
