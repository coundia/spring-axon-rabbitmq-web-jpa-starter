package com.groupe2cs.bizyhub.security.domain.valueObject;

import com.groupe2cs.bizyhub.security.domain.exception.UserRoleRoleNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserRoleRole implements Serializable {

	private String role;

	public UserRoleRole(String role) {
		this.role = role;
	}

	public static UserRoleRole create(String role) {
		if (role == null || role.isBlank()) {
			throw new UserRoleRoleNotValid("Role is invalid");
		}
		return new UserRoleRole(role);
	}

	public String value() {
		return this.role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserRoleRole that)) return false;
		return this.role.equals(that.role);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(role);
	}

	@Override
	public String toString() {
		return String.valueOf(role);
	}
}
