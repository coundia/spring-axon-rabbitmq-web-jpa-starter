package com.groupe2cs.bizyhub.security.domain.valueObject;

import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyActiveNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ApiKeyActive implements Serializable {

	private Boolean active;

	public ApiKeyActive(Boolean active) {
		this.active = active;
	}

	public static ApiKeyActive create(Boolean active) {

		if (active == null) {
			throw new ApiKeyActiveNotValid("Active is invalid");
		}
		return new ApiKeyActive(active);
	}

	public Boolean value() {
		return this.active;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ApiKeyActive that)) return false;
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
