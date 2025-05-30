package com.groupe2cs.bizyhub.categories.domain.valueObject;

import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIsActiveNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CategoryIsActive implements Serializable {

	private Boolean isActive;

	public CategoryIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public static CategoryIsActive create(Boolean isActive) {

		if (isActive == null) {
			throw new CategoryIsActiveNotValid("IsActive is invalid");
		}
		return new CategoryIsActive(isActive);
	}

	public Boolean value() {
		return this.isActive;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryIsActive that)) return false;
		return this.isActive.equals(that.isActive);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isActive);
	}

	@Override
	public String toString() {
		return String.valueOf(isActive);
	}
}
