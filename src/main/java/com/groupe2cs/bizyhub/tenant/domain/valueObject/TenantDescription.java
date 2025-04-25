package com.groupe2cs.bizyhub.tenant.domain.valueObject;

import com.groupe2cs.bizyhub.tenant.domain.exception.TenantDescriptionNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TenantDescription implements Serializable {

	private String description;

	public TenantDescription(String description) {
		this.description = description;
	}

	public static TenantDescription create(String description) {
		if (description == null || description.isBlank()) {
			throw new TenantDescriptionNotValid("Description is invalid");
		}
		return new TenantDescription(description);
	}

	public String value() {
		return this.description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TenantDescription that)) return false;
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
