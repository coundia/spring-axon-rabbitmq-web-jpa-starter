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
public class UserIsBan implements Serializable {

	private Boolean isBan;

	public UserIsBan(Boolean isBan) {
		this.isBan = isBan;
	}

	public static UserIsBan create(Boolean isBan) {

		return new UserIsBan(isBan);
	}

	public Boolean value() {
		return this.isBan;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserIsBan that)) return false;
		return this.isBan.equals(that.isBan);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isBan);
	}

	@Override
	public String toString() {
		return String.valueOf(isBan);
	}
}
