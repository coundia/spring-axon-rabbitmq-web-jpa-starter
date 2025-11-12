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
public class UserTelephone implements Serializable {

	private String telephone;

	public UserTelephone(String telephone) {
		this.telephone = telephone;
	}

	public static UserTelephone create(String telephone) {

		return new UserTelephone(telephone);
	}

	public String value() {
		return this.telephone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserTelephone that)) return false;
		return this.telephone.equals(that.telephone);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(telephone);
	}

	@Override
	public String toString() {
		return String.valueOf(telephone);
	}
}
