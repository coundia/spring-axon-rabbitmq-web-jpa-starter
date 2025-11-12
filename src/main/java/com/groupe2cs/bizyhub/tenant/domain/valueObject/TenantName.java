package com.groupe2cs.bizyhub.tenant.domain.valueObject;

import com.groupe2cs.bizyhub.tenant.domain.exception.TenantNameNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TenantName implements Serializable {

	private String name;

	public TenantName(String name) {
		this.name = name;
	}

	public static TenantName create(String name) {

		if (name == null || name.isBlank()) {
			throw new TenantNameNotValid("Name is invalid");
		}
		return new TenantName(name);
	}

	public String value() {
		return this.name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TenantName that)) return false;
		return this.name.equals(that.name);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(name);
	}

	@Override
	public String toString() {
		return String.valueOf(name);
	}
}
