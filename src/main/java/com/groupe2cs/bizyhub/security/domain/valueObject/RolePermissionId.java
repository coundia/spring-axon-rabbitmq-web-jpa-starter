package com.groupe2cs.bizyhub.security.domain.valueObject;

import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionIdNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class RolePermissionId implements Serializable {

	private String id;

	public RolePermissionId(String id) {
		this.id = id;
	}

	public static RolePermissionId create(String id) {

		if (id == null || id.isBlank()) {
			throw new RolePermissionIdNotValid("Id is invalid");
		}
		return new RolePermissionId(id);
	}

	public String value() {
		return this.id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RolePermissionId that)) return false;
		return this.id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(id);
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
