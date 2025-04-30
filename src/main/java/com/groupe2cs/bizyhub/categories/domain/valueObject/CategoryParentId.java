package com.groupe2cs.bizyhub.categories.domain.valueObject;

import com.groupe2cs.bizyhub.categories.domain.exception.CategoryParentIdNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CategoryParentId implements Serializable {

	private String parentId;

	public CategoryParentId(String parentId) {
		this.parentId = parentId;
	}

	public static CategoryParentId create(String parentId) {
		if (parentId == null || parentId.isBlank()) {
			throw new CategoryParentIdNotValid("ParentId is invalid");
		}
		return new CategoryParentId(parentId);
	}

	public String value() {
		return this.parentId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryParentId that)) return false;
		return this.parentId.equals(that.parentId);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(parentId);
	}

	@Override
	public String toString() {
		return String.valueOf(parentId);
	}
}
