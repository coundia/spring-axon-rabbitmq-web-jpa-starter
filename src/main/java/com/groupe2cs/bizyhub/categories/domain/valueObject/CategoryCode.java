package com.groupe2cs.bizyhub.categories.domain.valueObject;

import com.groupe2cs.bizyhub.categories.domain.exception.CategoryCodeNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CategoryCode implements Serializable {

	private String code;

	public CategoryCode(String code) {
		this.code = code;
	}

	public static CategoryCode create(String code) {

		if (code == null || code.isBlank()) {
			throw new CategoryCodeNotValid("Code is invalid");
		}
		return new CategoryCode(code);
	}

	public String value() {
		return this.code;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryCode that)) return false;
		return this.code.equals(that.code);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(code);
	}

	@Override
	public String toString() {
		return String.valueOf(code);
	}
}
