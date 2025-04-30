package com.groupe2cs.bizyhub.categories.domain.valueObject;

import com.groupe2cs.bizyhub.categories.domain.exception.CategoryTypeCategoryNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CategoryTypeCategory implements Serializable {

	private String typeCategory;

	public CategoryTypeCategory(String typeCategory) {
		this.typeCategory = typeCategory;
	}

	public static CategoryTypeCategory create(String typeCategory) {
		if (typeCategory == null || typeCategory.isBlank()) {
			throw new CategoryTypeCategoryNotValid("TypeCategory is invalid");
		}
		return new CategoryTypeCategory(typeCategory);
	}

	public String value() {
		return this.typeCategory;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryTypeCategory that)) return false;
		return this.typeCategory.equals(that.typeCategory);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(typeCategory);
	}

	@Override
	public String toString() {
		return String.valueOf(typeCategory);
	}
}
