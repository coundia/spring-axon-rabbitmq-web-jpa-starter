package com.groupe2cs.bizyhub.categories.domain.valueObject;

import com.groupe2cs.bizyhub.categories.domain.exception.CategoryNameNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CategoryName implements Serializable {

	private String name;

	public CategoryName(String name) {
		this.name = name;
	}

	public static CategoryName create(String name) {

		if (name == null || name.isBlank()) {
			throw new CategoryNameNotValid("Name is invalid");
		}
		return new CategoryName(name);
	}

	public String value() {
		return this.name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryName that)) return false;
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
