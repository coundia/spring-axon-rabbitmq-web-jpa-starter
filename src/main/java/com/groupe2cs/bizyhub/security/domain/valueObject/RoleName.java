package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.security.domain.exception.RoleIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.RoleNameNotValid;

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
public class RoleName implements Serializable {

	private String name;

	public RoleName(String name) {
		this.name = name;
	}

	public static RoleName create(String name) {

		if (name == null || name.isBlank()) {
			throw new RoleNameNotValid("Name is invalid");
		}
		return new RoleName(name);
	}

	public String value() {
		return this.name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RoleName that)) return false;
		return this.name.equals(that.name);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(name);
	}

	@Override
	public String toString() {
		return String.valueOf(name);
	}
}
