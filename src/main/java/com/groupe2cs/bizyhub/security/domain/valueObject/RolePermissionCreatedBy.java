package com.groupe2cs.bizyhub.security.domain.valueObject;

import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionCreatedByNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class RolePermissionCreatedBy implements Serializable {

	private String createdBy;

	public RolePermissionCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public static RolePermissionCreatedBy create(String createdBy) {
		if (createdBy == null || createdBy.isBlank()) {
			throw new RolePermissionCreatedByNotValid("CreatedBy is invalid");
		}
		return new RolePermissionCreatedBy(createdBy);
	}

	public String value() {
		return this.createdBy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RolePermissionCreatedBy that)) return false;
		return this.createdBy.equals(that.createdBy);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(createdBy);
	}

	@Override
	public String toString() {
		return String.valueOf(createdBy);
	}
}
