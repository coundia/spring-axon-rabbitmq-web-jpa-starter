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
public class UserFirstName implements Serializable {

	private String firstName;

	public UserFirstName(String firstName) {
		this.firstName = firstName;
	}

	public static UserFirstName create(String firstName) {

		return new UserFirstName(firstName);
	}

	public String value() {
		return this.firstName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserFirstName that)) return false;
		return this.firstName.equals(that.firstName);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(firstName);
	}

	@Override
	public String toString() {
		return String.valueOf(firstName);
	}
}
