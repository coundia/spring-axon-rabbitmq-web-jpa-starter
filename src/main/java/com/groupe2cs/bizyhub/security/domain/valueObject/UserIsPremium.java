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
public class UserIsPremium implements Serializable {

	private Boolean isPremium;

	public UserIsPremium(Boolean isPremium) {
		this.isPremium = isPremium;
	}

	public static UserIsPremium create(Boolean isPremium) {

		return new UserIsPremium(isPremium);
	}

	public Boolean value() {
		return this.isPremium;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserIsPremium that)) return false;
		return this.isPremium.equals(that.isPremium);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isPremium);
	}

	@Override
	public String toString() {
		return String.valueOf(isPremium);
	}
}
