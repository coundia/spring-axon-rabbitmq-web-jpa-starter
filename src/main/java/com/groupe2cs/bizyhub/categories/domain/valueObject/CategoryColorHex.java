package com.groupe2cs.bizyhub.categories.domain.valueObject;

import com.groupe2cs.bizyhub.categories.domain.exception.CategoryColorHexNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CategoryColorHex implements Serializable {

	private String colorHex;

	public CategoryColorHex(String colorHex) {
		this.colorHex = colorHex;
	}

	public static CategoryColorHex create(String colorHex) {
		if (colorHex == null || colorHex.isBlank()) {
			throw new CategoryColorHexNotValid("ColorHex is invalid");
		}
		return new CategoryColorHex(colorHex);
	}

	public String value() {
		return this.colorHex;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryColorHex that)) return false;
		return this.colorHex.equals(that.colorHex);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(colorHex);
	}

	@Override
	public String toString() {
		return String.valueOf(colorHex);
	}
}
