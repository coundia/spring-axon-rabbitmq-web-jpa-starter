package com.groupe2cs.bizyhub.companies.domain.valueObject;

import com.groupe2cs.bizyhub.companies.domain.exception.CompanyIdNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CompanyId implements Serializable {

	private String id;

	public CompanyId(String id) {
		this.id = id;
	}

	public static CompanyId create(String id) {

		if (id == null || id.isBlank()) {
			throw new CompanyIdNotValid("Id is invalid");
		}
		return new CompanyId(id);
	}

	public String value() {
		return this.id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CompanyId that)) return false;
		return this.id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(id);
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
