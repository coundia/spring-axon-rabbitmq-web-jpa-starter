package com.groupe2cs.bizyhub.tenant.domain.valueObject;

import com.groupe2cs.bizyhub.tenant.domain.exception.TenantActiveNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TenantActive implements Serializable {

	private Boolean active;

	public TenantActive(Boolean active) {
		this.active = active;
	}

	public static TenantActive create(Boolean active) {
		if (active == null) {
			throw new TenantActiveNotValid("Active is invalid");
		}
		return new TenantActive(active);
	}

	public Boolean value() {
		return this.active;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TenantActive that)) return false;
		return this.active.equals(that.active);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(active);
	}

	@Override
	public String toString() {
		return String.valueOf(active);
	}
}
