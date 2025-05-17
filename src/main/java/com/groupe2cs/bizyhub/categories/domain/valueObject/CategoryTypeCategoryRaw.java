package com.groupe2cs.bizyhub.categories.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CategoryTypeCategoryRaw implements Serializable {

	private String typeCategoryRaw;

	public CategoryTypeCategoryRaw(String typeCategoryRaw) {
		this.typeCategoryRaw = typeCategoryRaw;
	}

	public static CategoryTypeCategoryRaw create(String typeCategoryRaw) {

		return new CategoryTypeCategoryRaw(typeCategoryRaw);
	}

	public String value() {
		return this.typeCategoryRaw;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryTypeCategoryRaw that)) return false;
		return this.typeCategoryRaw.equals(that.typeCategoryRaw);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(typeCategoryRaw);
	}

	@Override
	public String toString() {
		return String.valueOf(typeCategoryRaw);
	}
}
