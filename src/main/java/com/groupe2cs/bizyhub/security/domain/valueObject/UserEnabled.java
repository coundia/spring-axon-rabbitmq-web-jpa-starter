package com.groupe2cs.bizyhub.security.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserEnabled implements Serializable {

	private Boolean enabled;

	public UserEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public static UserEnabled create(Boolean enabled) {

		return new UserEnabled(enabled);
	}

	public Boolean value() {
		return this.enabled;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserEnabled that)) return false;
		return this.enabled.equals(that.enabled);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(enabled);
	}

	@Override
	public String toString() {
		return String.valueOf(enabled);
	}
}
