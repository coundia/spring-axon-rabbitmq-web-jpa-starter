package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.security.domain.exception.UserRoleIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserRoleUserNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserRoleRoleNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserRoleCreatedByNotValid;

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
public class UserRoleCreatedBy implements Serializable {

	private String createdBy;

	public UserRoleCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public static UserRoleCreatedBy create(String createdBy) {

		return new UserRoleCreatedBy(createdBy);
	}

	public String value() {
		return this.createdBy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserRoleCreatedBy that)) return false;
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
