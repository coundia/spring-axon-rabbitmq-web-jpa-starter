package com.groupe2cs.bizyhub.categories.domain.valueObject;

import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIsDefaultNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CategoryIsDefault implements Serializable {

	private Boolean isDefault;

	public CategoryIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public static CategoryIsDefault create(Boolean isDefault) {
		if (isDefault == null) {
			throw new CategoryIsDefaultNotValid("IsDefault is invalid");
		}
		return new CategoryIsDefault(isDefault);
	}

	public Boolean value() {
		return this.isDefault;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryIsDefault that)) return false;
		return this.isDefault.equals(that.isDefault);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isDefault);
	}

	@Override
	public String toString() {
		return String.valueOf(isDefault);
	}
}
