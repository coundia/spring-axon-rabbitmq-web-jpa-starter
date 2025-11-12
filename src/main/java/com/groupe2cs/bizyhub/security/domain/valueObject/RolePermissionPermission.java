package com.groupe2cs.bizyhub.security.domain.valueObject;

import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionPermissionNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class RolePermissionPermission implements Serializable {

	private String permission;

	public RolePermissionPermission(String permission) {
		this.permission = permission;
	}

	public static RolePermissionPermission create(String permission) {

		if (permission == null || permission.isBlank()) {
			throw new RolePermissionPermissionNotValid("Permission is invalid");
		}
		return new RolePermissionPermission(permission);
	}

	public String value() {
		return this.permission;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RolePermissionPermission that)) return false;
		return this.permission.equals(that.permission);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(permission);
	}

	@Override
	public String toString() {
		return String.valueOf(permission);
	}
}
