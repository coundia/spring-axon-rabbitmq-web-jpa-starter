package com.groupe2cs.bizyhub.companies.domain.valueObject;

import com.groupe2cs.bizyhub.companies.domain.exception.CompanyIsDefaultNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CompanyIsDefault implements Serializable {

	private Boolean isDefault;

	public CompanyIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public static CompanyIsDefault create(Boolean isDefault) {

		if (isDefault == null) {
			throw new CompanyIsDefaultNotValid("IsDefault is invalid");
		}
		return new CompanyIsDefault(isDefault);
	}

	public Boolean value() {
		return this.isDefault;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CompanyIsDefault that)) return false;
		return this.isDefault.equals(that.isDefault);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isDefault);
	}

	@Override
	public String toString() {
		return String.valueOf(isDefault);
	}
}
