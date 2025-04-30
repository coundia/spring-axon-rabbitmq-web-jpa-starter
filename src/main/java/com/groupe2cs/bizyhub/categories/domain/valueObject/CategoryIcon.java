package com.groupe2cs.bizyhub.categories.domain.valueObject;

import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIconNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CategoryIcon implements Serializable {

	private String icon;

	public CategoryIcon(String icon) {
		this.icon = icon;
	}

	public static CategoryIcon create(String icon) {
		if (icon == null || icon.isBlank()) {
			throw new CategoryIconNotValid("Icon is invalid");
		}
		return new CategoryIcon(icon);
	}

	public String value() {
		return this.icon;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryIcon that)) return false;
		return this.icon.equals(that.icon);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(icon);
	}

	@Override
	public String toString() {
		return String.valueOf(icon);
	}
}
