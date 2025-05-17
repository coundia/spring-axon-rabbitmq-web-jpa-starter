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
public class PermissionCreatedBy implements Serializable {

	private String createdBy;

	public PermissionCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public static PermissionCreatedBy create(String createdBy) {

		return new PermissionCreatedBy(createdBy);
	}

	public String value() {
		return this.createdBy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PermissionCreatedBy that)) return false;
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
