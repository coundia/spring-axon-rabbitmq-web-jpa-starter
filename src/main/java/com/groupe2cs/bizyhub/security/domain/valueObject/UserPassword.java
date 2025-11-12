package com.groupe2cs.bizyhub.security.domain.valueObject;

import com.groupe2cs.bizyhub.security.domain.exception.UserPasswordNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserPassword implements Serializable {

	private String password;

	public UserPassword(String password) {
		this.password = password;
	}

	public static UserPassword create(String password) {

		if (password == null || password.isBlank()) {
			throw new UserPasswordNotValid("Password is invalid");
		}
		return new UserPassword(password);
	}

	public String value() {
		return this.password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserPassword that)) return false;
		return this.password.equals(that.password);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(password);
	}

	@Override
	public String toString() {
		return String.valueOf(password);
	}
}
