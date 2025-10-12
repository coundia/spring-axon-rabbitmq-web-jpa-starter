package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionRoleNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionPermissionNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RolePermissionCreatedByNotValid;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.*;
import java.util.*;

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
