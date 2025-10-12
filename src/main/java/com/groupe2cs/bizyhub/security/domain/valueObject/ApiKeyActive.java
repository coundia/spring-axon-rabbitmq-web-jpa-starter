package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyAppKeyNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyActiveNotValid;

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
